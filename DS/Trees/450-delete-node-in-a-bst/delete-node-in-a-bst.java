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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;

        if(root.val==key){
            if(root.left==null){
                return root.right;
            } else if(root.right==null){
                return root.left;
            } else{
                TreeNode t = root.right;
                TreeNode curr = t;
                while(curr.left!=null){
                    curr=curr.left;
                }
                curr.left=root.left;
                return t;
            }
        } else if(root.val>key){
            root.left = deleteNode(root.left, key);
        } else{
            root.right = deleteNode(root.right, key);
        }

        return root;
    }
}