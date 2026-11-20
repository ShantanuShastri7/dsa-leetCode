class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> charToLastIndex = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char a = s.charAt(i);
            charToLastIndex.put(a, i);
        }
        int currLength=1;
        int it=0;

        int expectedEnd=0;
        while(it<s.length()){
            char a = s.charAt(it);
            expectedEnd = Math.max(expectedEnd, charToLastIndex.get(a));

            if(it==expectedEnd){
                res.add(currLength);
                currLength=0;
            }
            it++;
            currLength++;
        }

        return res;
    }
}