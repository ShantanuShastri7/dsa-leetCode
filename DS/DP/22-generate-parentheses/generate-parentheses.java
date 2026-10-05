class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        StringBuilder str = new StringBuilder();

        helper(0, 0, 0, str, res, n);

        return res;
    }

    private void helper(int index, int openUsed, int closedUsed, StringBuilder str, List<String> res, int n){
        if(index == n*2){
            if(openUsed==closedUsed && openUsed==n){
                res.add(str.toString());
                return;
            }else return;
        }


        str.append('(');
        helper(index+1, openUsed+1, closedUsed, str, res, n);

        str.deleteCharAt(str.length()-1);

        if(openUsed>closedUsed){
            str.append(')');
            helper(index+1, openUsed, closedUsed+1, str, res, n);
            str.deleteCharAt(str.length() - 1);
        }

        return;
    }
}