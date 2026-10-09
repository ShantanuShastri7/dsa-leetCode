class Solution {
    public int minInsertions(String s) {
        int res=0;

        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                st.push(s.charAt(i));
            }else{
                boolean doubleClose = false;
                if(i+1<s.length()){
                    if(s.charAt(i+1)==')'){
                        doubleClose = true;
                        i++;
                    }
                }
                if(!doubleClose) res++;

                if(st.isEmpty()) res++;
                else{
                    st.pop();
                }
            }
        }

        if(st.isEmpty()){
            return res;
        }else{
            return res+st.size()*2;
        }
    }
}