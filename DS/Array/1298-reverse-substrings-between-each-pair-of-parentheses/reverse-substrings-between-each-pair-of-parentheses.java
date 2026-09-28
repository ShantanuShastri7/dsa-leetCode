class Solution {
    public String reverseParentheses(String s) {
        return helper(s, 0).get(0);
    }

    private List<String> helper(String s, int startIndex){
        StringBuilder str = new StringBuilder();
        int closingBracket=-1;

        for(int i=startIndex; i<s.length(); i++){
            if(s.charAt(i)=='('){
                List<String> res = helper(s, i+1);
                str.append(res.get(0));
                int nextI = Integer.valueOf(res.get(1));
                i=nextI;
            } else if(s.charAt(i)==')'){
                str.reverse();
                closingBracket=i;
                break;
            } else{
                str.append(s.charAt(i));
            }
        }
        List<String> ans = new ArrayList<>();
        ans.add(str.toString());
        ans.add(String.valueOf(closingBracket));

        return ans;
    }
}