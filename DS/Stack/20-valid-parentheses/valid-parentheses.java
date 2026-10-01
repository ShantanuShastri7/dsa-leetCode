class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            Character c = s.charAt(i);
            if(st.isEmpty()){
                st.push(c);
            } else{
                if(c==')' && st.peek()=='(') st.pop();
                else if(c==']' && st.peek()=='[') st.pop();
                else if(c=='}' && st.peek()=='{') st.pop();
                else st.push(c);
            }
        }

        return st.size()==0;
    }
}