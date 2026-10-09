class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // The initial "boundary" before index 0
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i); // Push index of '('
            } else {
                stack.pop(); // Match the ')'
                
                if (stack.isEmpty()) {
                    // This ')' was invalid. It becomes our new boundary wall.
                    stack.push(i);
                } else {
                    // Calculate the length from the current index back to the last unmatched index
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }

    private int helper(String s, StringBuilder str, int index){
        if(index>=s.length()){
            if(isValid(str)) return str.length();
            else return -1;
        }

        str.append(s.charAt(index));
        int pick = helper(s, str, index+1);

        str.deleteCharAt(str.length()-1);

        int notPick = helper(s, str, index+1);

        return Math.max(pick, notPick);
    }

    private boolean isValid(StringBuilder str){
        Stack<Character> st = new Stack<>();

        String s = str.toString();

        for(int i=0; i<s.length(); i++){
            if(st.isEmpty() || s.charAt(i)=='('){
                st.push(s.charAt(i));
            }else if(s.charAt(i)==')' && st.peek()=='('){
                st.pop();
            }else{
                return false;
            }
        }

        return st.size()>0?false:true;
    }
}