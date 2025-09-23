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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode LCA = getLCA(root, startValue, destValue);

        StringBuilder str = new StringBuilder();
        Integer leftDepth = getLeftDepth(LCA, startValue);
        getRightPath(LCA, destValue, str);

        StringBuilder left = new StringBuilder();

        while(leftDepth>1){
            left.append("U");
            leftDepth--;
        }
        String leftFinal = left.toString();
        System.out.print("left: " + leftFinal);
        String rightFinal = str.reverse().toString();
        System.out.print(" right: " + rightFinal);
        return leftFinal+rightFinal;
    }

    private int getLeftDepth(TreeNode node, int target){
        if(node==null) return 0;
        if(node.val==target) return 1;

        int left = getLeftDepth(node.left, target);
        int right = getLeftDepth(node.right, target);

        if(left+right>0) return Math.max(left, right)+1;
        return 0;
    }

    private boolean getRightPath(TreeNode node, int target, StringBuilder str){
        if(node==null) return false;
        if(node.val == target) return true;

        Boolean left = getRightPath(node.left, target, str);
        Boolean right = getRightPath(node.right, target, str);

        if(left){
            str.append("L");
        } else if(right){
            str.append("R");
        }

        return left||right;
    }

    private TreeNode getLCA(TreeNode node, int first, int second){
        if(node==null) return null;
        if(node.val==first || node.val==second) return node;

        TreeNode left = getLCA(node.left, first, second);
        TreeNode right = getLCA(node.right, first, second);

        if(left!=null && right!=null) {
            return node;
        } else if(left==null){
            return right;
        } else {
            return left;
        }
    }
}