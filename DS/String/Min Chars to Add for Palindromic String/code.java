class Solution {
    public int minChar(String s) {
        StringBuilder str = new StringBuilder();
        str.append(s);
        String rev = str.reverse().toString();
        
        String newStr = s+"$"+rev;
        
        int[] lps = calculateLPS(newStr);
        
        return s.length() - lps[lps.length-1];
        
    }
    
    private int[] calculateLPS(String s){
        int[] lps = new int[s.length()];
        lps[0]=0;
        int len=0;
        int start=1;
        
        while(start<s.length()){
            if(s.charAt(start)==s.charAt(len)){
                len++;
                lps[start]=len;
                start++;
            } else {
                if(len==0){
                    lps[start]=0;
                    start++;
                } else {
                    len = lps[len-1];
                }
            }
        }
        
        return lps;
    }
}
