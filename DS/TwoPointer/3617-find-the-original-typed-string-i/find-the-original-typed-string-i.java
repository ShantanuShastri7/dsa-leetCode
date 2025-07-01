class Solution {
    public int possibleStringCount(String word) {
        if(word==null) return 0;
        if(word.length()<2) return 1;
        int ans = 1;

        for(int i=0; i<word.length(); i++){ 
            for(int j=i+1; j<word.length(); j++){
                if(word.charAt(i)==word.charAt(j)){
                    ans++;
                } else{
                    i=j-1;
                    break;
                }
                if(j==word.length()-1) return ans;
            }
        }

        return ans;
    }
}