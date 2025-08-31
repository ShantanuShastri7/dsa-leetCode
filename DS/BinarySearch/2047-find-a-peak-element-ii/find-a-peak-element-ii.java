class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int[][] moves = {
                { -1, 0 },
                { 1, 0 }, 
                { 0, -1 }, 
                { 0, 1 } };

        int a=0;
        int b=0; 
        boolean returnResult=true;

        while(true){
            for(int[] move : moves){
                int new_a = a+move[0];
                int new_b = b+move[1];

                if(((new_a<0 || new_a>=mat.length) || (new_b<0 || new_b>=mat[0].length)) || mat[a][b]>mat[new_a][new_b]) {
                    returnResult=true;
                    continue;
                }
                else {
                    a=new_a;
                    b=new_b;
                    returnResult=false;
                    break;
                }
            }

            if(returnResult) return new int[]{a,b};
        }
    }
}