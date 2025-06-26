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
    public int kthSmallest(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        
        helper(root, q);
        int result=0;
        for(int i=0; i<k; i++){
            result = q.poll().val;
        }

        return result;
    }

    private void helper(TreeNode root, Queue<TreeNode> q){
        if(root==null) return;

        helper(root.left, q);
        q.offer(root);
        helper(root.right, q);

        return;
    }
}