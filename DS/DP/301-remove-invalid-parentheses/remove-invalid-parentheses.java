class Solution {
    public List<String> removeInvalidParentheses(String s) {
        StringBuilder str = new StringBuilder();
        HashSet<String> res = new HashSet<>();

        Map<Integer, HashSet<String>> map = new HashMap<>();
        helper(s, 0, str, map);

        for(int i=0; i<=s.length(); i++){
            if(map.containsKey(i)){
                res =  map.get(i);
                break;
            }
        }

        return new ArrayList<>(res);
    }

    private void helper(String s, int index, StringBuilder str, Map<Integer, HashSet<String>> res){
        if(index>=s.length()){
            boolean isValid = isValid(str);
            if(isValid){
                int rem = s.length() - str.length();
                if(res.containsKey(rem)){
                    if(str.length()==0){
                        res.get(rem).add("");
                    }else{
                        res.get(rem).add(str.toString());
                    }
                }else{
                    res.put(rem, new HashSet<>(Set.of(str.toString())));
                }
            }
            return;
        }

        //Not Pick
        if(s.charAt(index)=='(' || s.charAt(index)==')'){
            helper(s, index+1, str, res);
        }

        //Pick
        str.append(s.charAt(index));
        helper(s, index+1, str, res);

        //BackTrack
        str.deleteCharAt(str.length()-1);

        return;
    }

    private boolean isValid(StringBuilder str){
        Stack<Character> st = new Stack<>();
        String s = str.toString();

        for(int i=0; i<str.length(); i++){
            if(s.charAt(i)=='('){
                st.push(s.charAt(i));
            }else if(s.charAt(i)==')'){
                if(st.size()>0){
                    st.pop();
                }else{
                    return false;
                }
            }
        }

        if(st.size()>0) return false;

        return true;
    }
}