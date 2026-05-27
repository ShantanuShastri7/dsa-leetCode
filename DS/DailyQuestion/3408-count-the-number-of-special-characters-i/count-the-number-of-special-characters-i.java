class Solution {
    public int numberOfSpecialChars(String word) {
        int[] occur = new int[26];
        int special=0;

        for(int i=0; i<word.length(); i++){
            int cap=0;
            int charIndex = (int) word.charAt(i);
            if(charIndex>=97){
                charIndex-=97;
            } else{
                cap=1;
                charIndex-=65;
            }

            if(occur[charIndex]==1 && cap==1){
                special++;
                occur[charIndex]=3;
            } else if(occur[charIndex]==2 && cap==0){
                special++;
                occur[charIndex]=3;
            }

            if(occur[charIndex]!=3){
                if(cap==1){
                    occur[charIndex]=2;
                }else{
                    occur[charIndex]=1;
                }
            }
        }

        return special;
    }
}