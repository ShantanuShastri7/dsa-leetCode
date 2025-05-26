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
    public boolean isSymmetric(TreeNode root) {
        boolean result = false;
        if (root.left != null && root.right != null) {
            if (root.left.val == root.right.val) {
                result = symmetric(root.left, root.right);
            } else {
                return false;
            }
        } else if(root.left == null && root.right == null){
            return true;
        }
        return result;
    }

    private boolean symmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if(root1!=null && root2!=null){
            if (root1.val == root2.val) {
                return symmetric(root1.left, root2.right) && symmetric(root1.right, root2.left);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}