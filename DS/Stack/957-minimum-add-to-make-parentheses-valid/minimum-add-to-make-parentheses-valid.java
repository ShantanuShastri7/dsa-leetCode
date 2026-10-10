class Solution {
    public int minAddToMakeValid(String s) {
        int res=0;

        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                st.push(s.charAt(i));
            }else{
                if(st.isEmpty()) res++;
                else{
                    st.pop();
                }
            }
        }

        if(st.isEmpty()){
            return res;
        }else{
            return res+st.size();
        }
    }
}