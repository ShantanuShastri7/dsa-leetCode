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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<>();
        result.add(root.val);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Queue<TreeNode> secondaryQueue = new ArrayDeque<>();
            while(!queue.isEmpty()){
                TreeNode curr = queue.poll();

                if(curr.right!=null) secondaryQueue.add(curr.right);
                if(curr.left!=null) secondaryQueue.add(curr.left);
            }
            if(secondaryQueue.peek()!=null){
                result.add(secondaryQueue.peek().val);
            }
            queue=secondaryQueue;
        }
        return result;
    }
}