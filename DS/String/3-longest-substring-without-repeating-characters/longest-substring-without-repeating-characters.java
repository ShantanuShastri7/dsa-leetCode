class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] index = new int[128];

        int count=0;
        int result=0;
        int l=0;
        int r=0;

        while(r<n){
            if(index[s.charAt(r)]==0){
                index[s.charAt(r)]++;
                count++;
                result=Math.max(count, result);
                r++;
            } else{
                while(index[s.charAt(r)]!=0){
                    index[s.charAt(l)]--;
                    l++;
                }
                count=r-l;
                result=Math.max(count, result);
            }
        }

        return result;
    }
}