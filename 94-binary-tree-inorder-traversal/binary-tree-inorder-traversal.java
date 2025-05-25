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
//     public List<Integer> inorderTraversal(TreeNode root) {
//         if(root == null){
//             return new ArrayList<>();
//         }

//         List<Integer> results = new ArrayList<>();
//         results = recurseInorder(root, results);
//         return results;
//     }

//     private List<Integer> recurseInorder(TreeNode root, List<Integer> result){
//         if(root == null){
//             return result;
//         } 

//         recurseInorder(root.left, result);
//         result.add(root.val);
//         recurseInorder(root.right, result);

//         return result;
//     }
// }

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        TreeNode curr=root;

        while(!stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr=curr.right;
        }

        return result.subList(0,result.size()-1);
    }
}