class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        int n = haystack.length();
        int m = needle.length();

        int[] lps =  calculateLPS(needle);

        // Step 2: Run KMP search
        int i = 0, j = 0;

        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

                if (j == m) {
                    return i - m;   // match found
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    private int[] calculateLPS(String needle){
        int[] lps = new int[needle.length()];

        int start=1;
        lps[0]=0;
        int len=0;
        while(start<needle.length()){
            if(needle.charAt(start)==needle.charAt(len)){
                lps[start]=len+1;
                len++;
                start++;
            } else{
                if(len==0) {
                    lps[start]=len;
                    start++;
                } else{
                    len=lps[len-1];
                }
            }
        }

        return lps;
    }
}