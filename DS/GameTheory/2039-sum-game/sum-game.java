class Solution {
    public boolean sumGame(String num) {
        long leftSum=0l;
        long rightSum=0l;
        int leftEmpty=0;
        int rightEmpty=0;

        for(int i=0; i<num.length()/2; i++){
            if(num.charAt(i)=='?') leftEmpty++;
            else leftSum+=Integer.valueOf(num.charAt(i)-'0');
        }

        for(int i=num.length()/2; i<num.length(); i++){
            if(num.charAt(i)=='?') rightEmpty++;
            else rightSum+=Integer.valueOf(num.charAt(i)-'0');
        }

        boolean aliceGetsMore = (leftEmpty+rightEmpty)%2==0?false:true;

        if(aliceGetsMore) return true;

        if (2 * (leftSum - rightSum) == (rightEmpty - leftEmpty) * 9) {
            return false; // Bob perfectly balances the board
        }

        return true;

    }
}