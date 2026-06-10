class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        Map<String, Integer> map = new HashMap<>();

        for (List<String> list : responses) {
            Set<String> uniqueResponses = new HashSet<>(list);
            
            for (String uniqueResp : uniqueResponses) {
                map.put(uniqueResp, map.getOrDefault(uniqueResp, 0) + 1);
            }
        }

        String highestWord = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int currentCount = entry.getValue();
            String currentWord = entry.getKey();
            
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                highestWord = entry.getKey();
            } else if (currentCount == maxCount) {
                if (highestWord.isEmpty() || currentWord.compareTo(highestWord) < 0) {
                    highestWord = currentWord;
                }
            }
        }

        return highestWord;
    }
}