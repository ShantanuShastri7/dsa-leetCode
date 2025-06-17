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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;

        int left = getHeight(root.left)+1;
        int right = getRightHeight(root.right)+1;

        if(left==right){
            return (int)Math.pow(2,left)-1;
        } else{
            return 1+countNodes(root.left)+countNodes(root.right);
        }

    }

    private int getHeight(TreeNode root){
        if(root==null) return 0;

        return getHeight(root.left)+1;
    }

    private int getRightHeight(TreeNode root){
        if(root==null) return 0;

        return getRightHeight(root.right)+1;
    }
}