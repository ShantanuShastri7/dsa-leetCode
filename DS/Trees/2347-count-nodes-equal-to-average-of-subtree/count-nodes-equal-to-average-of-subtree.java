/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int averageOfSubtree(TreeNode root) {
        int[] res = new int[1];
        res[0]=0;

        helper(root, res);

        return res[0];
    }

    private int[] helper(TreeNode root, int[] res){
        if(root==null) return new int[]{0,0};

        int[] leftSum = helper(root.left, res);
        int[] rightSum = helper(root.right, res);

        if((leftSum[0]+rightSum[0]+root.val)/(leftSum[1]+rightSum[1]+1) == root.val){
            res[0]++;
        }

        return new int[]{leftSum[0]+rightSum[0]+root.val, leftSum[1]+rightSum[1]+1};
    }


}