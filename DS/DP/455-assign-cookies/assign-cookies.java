class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count=0;
        int jStart=0;

        for(int i=0; i<s.length; i++){
            for(int j=jStart; j<g.length; j++){
                if(g[j]<=s[i]) {
                    count++;
                    jStart=j+1;
                    break;
                }

            }
        }

        return count;
    }
}