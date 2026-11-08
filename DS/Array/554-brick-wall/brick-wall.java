class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Long, Integer> gaps = new HashMap<>();
        int n = wall.size();

        for(int i=0; i<wall.size(); i++){
            Long start=0l;
            if(wall.get(i).size()==1) continue;
            for(int j=0; j<wall.get(i).size()-1; j++){
                Long gap = start + (long)wall.get(i).get(j);
                gaps.put(gap, gaps.getOrDefault(gap, 0) + 1);
                start = gap;
            }
        }

        int gapFreq = Integer.MIN_VALUE;
        for(Map.Entry<Long, Integer> g : gaps.entrySet()){
            if(g.getValue()>gapFreq){
                gapFreq = g.getValue();
            }
        }

        return gapFreq==Integer.MIN_VALUE?n:n-gapFreq;
    }
}