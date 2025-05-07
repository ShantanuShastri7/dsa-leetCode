class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();

        for(String query : queries){
            for(String dictionari : dictionary){
                if(numOfEdits(query, dictionari)){
                    result.add(query);
                    break;
                }
            }
        }

        return result;
    }

    private boolean numOfEdits(String query, String dictionary){
        int numOfEdits = 0;

        for(int i=0; i<query.length(); i++){
            if(query.charAt(i)!=dictionary.charAt(i)){
                numOfEdits++;
            }
        }

        return numOfEdits>2?false:true;
    }
}