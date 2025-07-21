class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int equalDominoes = 0;
        HashMap<Integer, Integer> similarMap = new HashMap<>();
        for(int i=0; i<dominoes.length; i++){
            Integer hashedNumber = hashFunction(dominoes[i][0], dominoes[i][1]);

            if(similarMap.containsKey(hashedNumber)){
                similarMap.put(hashedNumber, similarMap.get(hashedNumber)+1);
            } else{
                similarMap.put(hashedNumber, 1);
            }
        }

        for(int count: similarMap.values()){
            if(count>1) {
                count = (count * (count - 1)) / 2;
                equalDominoes+=count;
            }
        }
        return equalDominoes;
    }


    private Integer hashFunction(Integer a, Integer b) {
        return Math.min(a,b) * 10 + Math.max(a,b);
    }

}