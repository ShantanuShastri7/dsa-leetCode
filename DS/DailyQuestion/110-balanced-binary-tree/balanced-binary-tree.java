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

        int depth = getDepth(root);

        if(depth==-1) return false;
        return true;

    }

    private int getDepth(TreeNode root){
        if(root==null) return 0;

        int depth1 = getDepth(root.left);
        int depth2 = getDepth(root.right);

        if(depth1==-1 || depth2==-1) return -1;

        if((depth1-depth2)<=1 && (depth1-depth2)>=-1) return Math.max(depth1, depth2)+1;

        return -1;
    }
}