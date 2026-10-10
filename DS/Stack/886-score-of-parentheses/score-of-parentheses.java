class Solution {
    public int scoreOfParentheses(String s) {
        int res=0;
        int mul=0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                mul++;
            }else{
                if(s.charAt(i-1)=='('){
                    res += 1 << (mul - 1);
                }
                mul--;
            }
        }

        return res;
    }
}