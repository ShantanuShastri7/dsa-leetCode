class Solution {
    public long maximumTotalDamage(int[] power) {
        // 1️⃣ Count frequency of each power
        Map<Integer, Long> map = new HashMap<>();
        for (int p : power) map.put(p, map.getOrDefault(p, 0L) + p);

        // 2️⃣ Sort unique power values
        List<Integer> values = new ArrayList<>(map.keySet());
        Collections.sort(values);

        // 3️⃣ Memo for recursion
        Map<Integer, Long> memo = new HashMap<>();

        // 4️⃣ Start recursion
        return dfs(0, values, map, memo);
    }

    private long dfs(int i, List<Integer> values, Map<Integer, Long> map, Map<Integer, Long> memo) {
        if (i >= values.size()) return 0;
        if (memo.containsKey(i)) return memo.get(i);

        // skip current power
        long notPick = dfs(i + 1, values, map, memo);

        // pick current power
        int next = i + 1;
        while (next < values.size() && values.get(next) <= values.get(i) + 2) next++;
        long pick = map.get(values.get(i)) + dfs(next, values, map, memo);

        long ans = Math.max(pick, notPick);
        memo.put(i, ans);
        return ans;
    }
}