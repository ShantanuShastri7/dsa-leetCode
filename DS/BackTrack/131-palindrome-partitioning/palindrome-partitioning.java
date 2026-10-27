class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();

        helper(s, 0, res, curr);

        return res;
    }

    private void helper(String s, int lastCut, List<List<String>> res, List<String> curr){
        if(lastCut==s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=lastCut+1; i<=s.length(); i++){
            String thisCut = s.substring(lastCut, i);
            if(isPalindrome(thisCut)){
                curr.add(thisCut);
                helper(s, i, res, curr);
                curr.remove(curr.size()-1);
            }
        }
        return;
    }

    private boolean isPalindrome(String s){
        int l=0;
        int r = s.length()-1;

        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }
}