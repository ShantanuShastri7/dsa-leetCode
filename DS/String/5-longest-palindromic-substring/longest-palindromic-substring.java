//Manacher's
class Solution {
    public String longestPalindrome(String s) {
        StringBuilder str = new StringBuilder("^");
        for(int i=0; i<s.length(); i++){
            str.append("#").append(s.charAt(i));
        }
        str.append("#$");

        String transformed = str.toString();

        int[] P = new int[transformed.length()];
        int C=0;
        int R=0;
        int maxLen=0; 
        int centerIndex=0;

        for(int i=1; i<transformed.length()-1; i++){
            int iMirror = 2*C-i;

            if(i<R){
                P[i] = Math.min(P[iMirror], R-i);
            }

            while(transformed.charAt(i+P[i]+1)==transformed.charAt(i-P[i]-1)){
                P[i]++;
            }

            if(i+P[i]>R){
                R=i+P[i];
                C=i;
            }

            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
}

//Normal expansion using even and odd length variations
// class Solution {
//     public String longestPalindrome(String s) {
//         if (s == null || s.length() < 1) return "";
        
//         int start = 0, end = 0;
        
//         for (int i = 0; i < s.length(); i++) {
            
//             int len1 = expand(s, i, i);

//             int len2 = expand(s, i, i + 1);
            
//             int len = Math.max(len1, len2);
            
//             if (len > end - start) {
//                 start = i - (len - 1) / 2;   
//                 end = i + len / 2;
//             }
//         }
        
//         return s.substring(start, end + 1);
//     }
    
//     private int expand(String s, int left, int right) {
//         while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//             left--;
//             right++;
//         }
//         return right - left - 1;  
//     }
// }