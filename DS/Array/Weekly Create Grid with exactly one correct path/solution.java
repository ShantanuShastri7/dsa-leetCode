class Solution {
    public String[] createGrid(int m, int n) {
        String[] answer = new String[m];

        for(int i=0; i<m; i++){
            StringBuilder x = new StringBuilder();
            for(int j=0; j<n; j++){
                if(i==0 || j==n-1){
                    x.append(".");
                } else{
                    x.append("#");
                }
            }
            answer[i]=x.toString();
        }

        return answer;
    }
}©leetcode
