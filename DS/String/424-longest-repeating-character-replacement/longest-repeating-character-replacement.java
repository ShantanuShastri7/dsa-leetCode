class Solution {
    public int characterReplacement(String s, int k) {
        int[] ind = new int[26];

        int l=0; 
        int r=0;
        int length=0;
        int maxF=0;
        int result=0;

        while(r<s.length()){
            int index=s.charAt(r)-'A';
            ind[index]++;

            maxF = Math.max(maxF, ind[index]);

            while(r-l+1-maxF>k){
                int delIndex=s.charAt(l)-'A';
                ind[delIndex]--;
                maxF = findMaxF(ind);
                l++;
            }

            result=Math.max(result, r-l+1);
            r++;
        }

        return result;
    }

    private int findMaxF(int[] ind){
        int result=0;

        for(int i : ind){
            result=Math.max(i, result);
        }

        return result;
    }
}