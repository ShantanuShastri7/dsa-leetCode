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
    public int maxPathSum(TreeNode root) {
        int[] result = new int[1];
        result[0]=Integer.MIN_VALUE;
        helper(root, result);

        return result[0];
    }

    private int helper(TreeNode root, int[] maxSum){
        if(root==null) return 0;

        int left = Math.max(0,helper(root.left, maxSum));
        int right = Math.max(0,helper(root.right, maxSum));

        if(root.val+left+right>maxSum[0]){
            maxSum[0]=root.val+left+right;
        }

        return Math.max(root.val+left, root.val+right);
    }
}