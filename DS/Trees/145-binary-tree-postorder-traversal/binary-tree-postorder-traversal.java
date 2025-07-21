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
// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         if(root==null) return new ArrayList<>();

//         ArrayList<Integer> results = new ArrayList<>();

//         recursePostOrder(root, results);

//         return results;

//     }

//     private List<Integer> recursePostOrder(TreeNode root, ArrayList<Integer> results){
//         if(root==null) return results;

//         recursePostOrder(root.left, results);
//         recursePostOrder(root.right, results);
//         results.add(root.val);

//         return results;
//     }
// }

//Single Stack solution iterative
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null) return new ArrayList<>();

        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();

        TreeNode curr = root;
        TreeNode lastVisited = null;

        while(!stack.isEmpty()||curr!=null){

            if(curr!=null){
                stack.push(curr);
                curr=curr.left;
            } else {
                TreeNode peekNode = stack.peek();

                if (peekNode.right != null && lastVisited != peekNode.right) {
                    curr = peekNode.right;
                } else {
                    results.add(peekNode.val);
                    lastVisited = stack.pop();
                }
            }
        }

        return results;
    }
}