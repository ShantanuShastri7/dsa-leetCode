class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        List<List<Integer>> ans = new ArrayList<>();

        int first=0;
        int second=0;

        while(first<series1.length && second<series2.length){
            int firstValue = series1[first][0];
            int secondValue = series2[second][0];

            if(firstValue<secondValue){
                int val = series1[first][1]+series2[second][1];
                ans.add(new ArrayList<>(Arrays.asList(firstValue, val)));
                first++;
            }else if(secondValue<firstValue){
                int val = series1[first][1]+series2[second][1];
                ans.add(new ArrayList<>(Arrays.asList(secondValue, val))); 
                second++;
            } else{
                int val = series1[first][1]+series2[second][1];
                ans.add(new ArrayList<>(Arrays.asList(secondValue, val))); 
                second++;
                first++;
            }
        }

        if(first<series1.length){
            while(first<series1.length){
                int val=series1[first][1];
                ans.add(new ArrayList<>(Arrays.asList(series1[first][0], val))); 
                first++;
            }
        }

        if(second<series2.length){
            while(second<series2.length){
                int val=series2[second][1];
                ans.add(new ArrayList<>(Arrays.asList(series2[second][0], val))); 
                second++;
            }
        }

        return ans;
    }
}