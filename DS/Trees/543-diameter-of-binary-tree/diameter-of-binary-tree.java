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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 1;
        int[] max = new int[1];
        findMaxH(root, max);

        return max[0];
    }

    private int findMaxH(TreeNode root, int[] max){
        if(root == null) return 0;

        int leftH = findMaxH(root.left, max);
        int rightH = findMaxH(root.right, max);

        max[0] = Math.max(max[0], leftH+rightH);

        return 1+Math.max(leftH,rightH);
    }
}