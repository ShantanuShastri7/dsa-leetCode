// User function Template for Java

class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        int[] prev = new int[s2.length()+1];
        int ans=0;
        // for (int i = 0; i <= s2.length(); i++) {
        //     prev[i] = 0;
        // }
        for (int i = 1; i <= s1.length(); i++) {
            int[] cur = new int[s2.length()+1];
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    cur[j] = 1 + prev[j - 1];
                    ans=Math.max(ans,cur[j]);
                } else {
                    cur[j] = 0;
                }
            }
            prev=cur;
        }
        
        return ans;
        
    }
}
