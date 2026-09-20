class Solution {
    public int reverseDegree(String s) {
        int res =0;

        for(int i=0; i<s.length(); i++){
            int current = s.charAt(i)-'a';
            res+=(i+1)*(26-current);
        }

        return res;
    }
}