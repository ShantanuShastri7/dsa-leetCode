class Solution {
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        ArrayList<Integer> result = new ArrayList<>();
        
        while(result.size()<mat.length*mat[0].length){
            if(!pq.isEmpty()){
                int[] largest = pq.poll();
                int num = largest[0];
                int row = largest[1];
                int column = largest[2];
                
                result.add(num);
                
                if(column+1<mat[0].length){
                    pq.offer(new int[]{mat[row][column+1], row, column+1});
                }
            } else{
                for(int i=0; i<mat.length; i++){
                    pq.offer(new int[]{mat[i][0], i, 0});
                }
            }
        }
        return result;
    }
}
