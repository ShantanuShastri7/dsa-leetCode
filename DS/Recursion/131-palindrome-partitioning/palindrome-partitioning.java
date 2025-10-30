class Solution {
    public ArrayList<List<String>> partition(String s) {
        ArrayList<List<String>> res = new ArrayList<>();
        ArrayList<String> curr = new ArrayList<>();

        helper(s, 0, res, curr);

        return res;
    }

    private void helper(String s, int index, ArrayList<List<String>> result, ArrayList<String> curr){
        if(index==s.length()){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index; i<s.length(); i++){
            if(isPalindrome(s, index, i)){
                curr.add(s.substring(index, i+1));
                helper(s, i+1, result, curr);
                curr.remove(curr.size()-1);
            }
        }

        return;
    }

    private boolean isPalindrome(String s, int start, int end){
        for(int i=start, j=end; i<=j; i++, j--){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }

        return true;
    }
}