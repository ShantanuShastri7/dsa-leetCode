class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] hasLower = new boolean[26];
        boolean[] hasUpper = new boolean[26];

        // 1. Record all occurrences
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'a' && c <= 'z') {
                hasLower[c - 'a'] = true;
            } else if (c >= 'A' && c <= 'Z') {
                hasUpper[c - 'A'] = true;
            }
        }

        // 2. Count characters that appear in both
        int special = 0;
        for (int i = 0; i < 26; i++) {
            if (hasLower[i] && hasUpper[i]) {
                special++;
            }
        }

        return special;
    }
}

// class Solution {
//     public int numberOfSpecialChars(String word) {
//         int[] occur = new int[26];
//         int special=0;

//         for(int i=0; i<word.length(); i++){
//             int cap=0;
//             int charIndex = (int) word.charAt(i);
//             if(charIndex>=97){
//                 charIndex-=97;
//             } else{
//                 cap=1;
//                 charIndex-=65;
//             }

//             if(occur[charIndex]==1 && cap==1){
//                 special++;
//                 occur[charIndex]=3;
//             } else if(occur[charIndex]==2 && cap==0){
//                 special++;
//                 occur[charIndex]=3;
//             }

//             if(occur[charIndex]!=3){
//                 if(cap==1){
//                     occur[charIndex]=2;
//                 }else{
//                     occur[charIndex]=1;
//                 }
//             }
//         }

//         return special;
//     }
// }