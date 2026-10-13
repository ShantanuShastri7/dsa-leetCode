class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res=0;
        int left=0; 
        int[] arr = new int[256];

        for(int i=0; i<s.length(); i++){
            int x = (int)s.charAt(i);
            arr[x]++;

            if(arr[x]==1){
                res=Math.max(res, i-left+1);
            }else{
                while(arr[x]>1){
                    int y = (int)s.charAt(left);
                    arr[y]--;
                    left++;
                }
                res=Math.max(res, i-left+1);
            }
        }

        return res;
    }
}