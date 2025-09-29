class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<numRows; i++){
            result.add(generateRow(i));
        }

        return result;
    }

    private ArrayList<Integer> generateRow(int rowNum){
        ArrayList<Integer> result = new ArrayList<>();

        int num=1;
        result.add(num);

        for(int i=0; i<rowNum; i++){
            num=num*(rowNum-i);
            num=num/(i+1);
            result.add(num);
        }

        return result;
    }
}