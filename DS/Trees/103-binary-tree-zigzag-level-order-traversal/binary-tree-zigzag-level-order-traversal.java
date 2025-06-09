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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();  
        ArrayList<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()){
            Stack<TreeNode> secondaryStack = new Stack<>();
            Stack<TreeNode> tertiaryStack = new Stack<>();
            ArrayList<Integer> levelResult = new ArrayList<>();
            ArrayList<Integer> levelResult2 = new ArrayList<>();
            while(!stack.isEmpty()){
                TreeNode curr = stack.pop();
                levelResult.add(curr.val);

                if(curr.left!=null) secondaryStack.add(curr.left);
                if(curr.right!=null) secondaryStack.add(curr.right);
            }
            stack = secondaryStack;
            result.add(levelResult);

            if(secondaryStack.isEmpty()) break;

            while(!stack.isEmpty()){
                TreeNode curr = stack.pop();
                levelResult2.add(curr.val);

                if(curr.right!=null) tertiaryStack.add(curr.right);
                if(curr.left!=null) tertiaryStack.add(curr.left);
            }

            result.add(levelResult2);
            stack = tertiaryStack;
        }
        return result;
    }
}