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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();
        ArrayList<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Queue<TreeNode> secondaryQueue = new ArrayDeque<>();
            ArrayList<Integer> levelResult = new ArrayList<>();
            while(!queue.isEmpty()){
                TreeNode curr = queue.poll();
                levelResult.add(curr.val);

                if(curr.left!=null) secondaryQueue.add(curr.left);
                if(curr.right!=null) secondaryQueue.add(curr.right);
            }
            queue=secondaryQueue;
            result.add(levelResult);
        }
        return result;
    }
}