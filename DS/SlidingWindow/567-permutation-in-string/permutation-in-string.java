class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1c = new int[26];
        int[] windowC = new int[26];

        for(int i=0;i<s1.length(); i++){
            s1c[s1.charAt(i)-'a']++;
        }

        int l=0;

        for(int r=0; r<s2.length(); r++){
            windowC[s2.charAt(r)-'a']++;

            if(r-l+1<s1.length()) continue;
            else{
                if(r-l+1==s1.length()){
                    if(check(windowC, s1c)) return true;
                }else{
                    windowC[s2.charAt(l)-'a']--;
                    l++;
                    if(check(windowC, s1c)) return true;
                }
            }
        }

        return false;
    }

    private boolean check(int[] windowC, int[] s1c){
        for(int i=0;i<26; i++){
            if(windowC[i]!=s1c[i]) return false;
        }

        return true;
    }
}