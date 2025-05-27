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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;

        int depth = balanced(root);

        if(depth==Integer.MAX_VALUE) return false;
        return true;
    }

    private int balanced(TreeNode root1){
        if(root1==null){
            return 0;
        }

        int leftD = balanced(root1.left);
        int rightD = balanced(root1.right);    

        if(leftD==Integer.MAX_VALUE || rightD==Integer.MAX_VALUE) return Integer.MAX_VALUE;

        if(leftD==rightD || leftD-rightD==1 || rightD-leftD==1){
            return Math.max(leftD,rightD)+1;
        } else {
            return Integer.MAX_VALUE;
        }

    }
}