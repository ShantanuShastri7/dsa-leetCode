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
//     public boolean isBalanced(TreeNode root) {
//         if(root==null) return true;

//         int depth = balanced(root);

//         if(depth==Integer.MAX_VALUE) return false;
//         return true;
//     }

//     private int balanced(TreeNode root1){
//         if(root1==null){
//             return 0;
//         }

//         int leftD = balanced(root1.left);
//         int rightD = balanced(root1.right);    

//         if(leftD==Integer.MAX_VALUE || rightD==Integer.MAX_VALUE) return Integer.MAX_VALUE;

//         if(leftD==rightD || leftD-rightD==1 || rightD-leftD==1){
//             return Math.max(leftD,rightD)+1;
//         } else {
//             return Integer.MAX_VALUE;
//         }

//     }
// }

class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // Helper function returns -1 if subtree is unbalanced, otherwise returns height
    private int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int left = checkHeight(node.left);
        if (left == -1) return -1; // left subtree is unbalanced

        int right = checkHeight(node.right);
        if (right == -1) return -1; // right subtree is unbalanced

        if (Math.abs(left - right) > 1) return -1; // current node is unbalanced

        return 1 + Math.max(left, right); // return height
    }
}