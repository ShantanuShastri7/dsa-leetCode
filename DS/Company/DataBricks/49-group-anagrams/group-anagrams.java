class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26]; // for 'a' to 'z'

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // Build a unique key based on counts
            StringBuilder keyBuilder = new StringBuilder();
            for (int num : count) {
                keyBuilder.append(num).append('#');
            }
            String key = keyBuilder.toString();

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
