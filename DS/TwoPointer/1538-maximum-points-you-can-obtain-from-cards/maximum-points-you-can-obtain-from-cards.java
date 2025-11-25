class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum=0;
        int rightSum=0;
        int result=0;

        for(int i=0; i<k; i++) leftSum+=cardPoints[i];

        result= leftSum;

        for(int i=0; i<k; i++){
            leftSum-=cardPoints[k-i-1];
            rightSum+=cardPoints[cardPoints.length-i-1];
            result=Math.max(result, (leftSum+rightSum));
        }

        return result;

    }
}