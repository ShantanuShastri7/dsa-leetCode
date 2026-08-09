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
    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        int[] max = new int[1];
        int maxSoFar = root.val;

        helper(root, max, maxSoFar);

        return max[0];
    }

    private void helper(TreeNode root, int[] max , int maxSoFar){
        if(root==null) return;

        if(root.val>=maxSoFar){
            max[0]++;
        }

        maxSoFar = Math.max(maxSoFar, root.val);

        helper(root.left, max, maxSoFar);
        helper(root.right, max, maxSoFar);

        return;
    }
}