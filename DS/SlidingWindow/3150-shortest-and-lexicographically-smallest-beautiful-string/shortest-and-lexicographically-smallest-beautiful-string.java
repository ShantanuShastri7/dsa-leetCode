class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int l = 0;
        int onesCount = 0;
        String res = "";
        
        for (int r = 0; r < s.length(); r++) {
            if (s.charAt(r) == '1') {
                onesCount++;
            }
            
            while (l <= r && (onesCount > k || s.charAt(l) == '0')) {
                if (s.charAt(l) == '1') {
                    onesCount--;
                }
                l++; 
            }
            
            if (onesCount == k) {
                String possible = s.substring(l, r + 1); 
                
                if (res.equals("")) {
                    res = possible;
                } else if (possible.length() < res.length()) {
                    res = possible;
                } else if (possible.length() == res.length()) {
                    res = res.compareTo(possible) < 0 ? res : possible;
                }
            }
            
        }
        
        return res;
    }
}