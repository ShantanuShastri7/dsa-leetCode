class Solution {
    public int maxDistance(String moves) {
        int up=0;
        int left=0;
        int open=0;

        for(int i=0; i<moves.length(); i++){
            char c = moves.charAt(i);

            if(c=='U'){
                up++;
            } else if(c=='D'){
                up--;
            } else if(c=='L'){
                left++;
            } else if(c=='R'){
                left--;
            } else{
                open++;
            }
        }

        return Math.abs(up)+Math.abs(left)+open;
    }
}