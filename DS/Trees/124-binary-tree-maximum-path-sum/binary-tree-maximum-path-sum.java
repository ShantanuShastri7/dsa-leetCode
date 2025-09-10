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
        result[0] = Integer.MIN_VALUE;

        getPathValue(root, result);
        return result[0];
    }

    private int getPathValue(TreeNode node, int[] result){
        if(node==null) return 0;

        int left = Math.max(0, getPathValue(node.left, result));
        int right = Math.max(0, getPathValue(node.right, result));

        result[0] = Math.max(result[0], left+right+node.val);

        return node.val + Math.max(left, right);
    }
}