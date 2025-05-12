class Solution {
    public int[] findEvenNumbers(int[] digits) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> digitsCount = new HashMap<>();

        for (int digit : digits) {
            digitsCount.put(digit, digitsCount.getOrDefault(digit, 0) + 1);
        }

        for (int i = 100; i <= 999; i += 2) {
            int d1 = i / 100;
            int d2 = (i / 10) % 10;
            int d3 = i % 10;

            HashMap<Integer, Integer> tempMap = new HashMap<>();
            tempMap.put(d1, tempMap.getOrDefault(d1, 0) + 1);
            tempMap.put(d2, tempMap.getOrDefault(d2, 0) + 1);
            tempMap.put(d3, tempMap.getOrDefault(d3, 0) + 1);

            boolean canForm = true;
            for (int digit : tempMap.keySet()) {
                if (digitsCount.getOrDefault(digit, 0) < tempMap.get(digit)) {
                    canForm = false;
                    break;
                }
            }

            if (canForm) {
                result.add(i);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
