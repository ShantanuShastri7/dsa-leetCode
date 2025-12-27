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
    public int maxSumBST(TreeNode root) {
        int[] res = new int[1];

        isBST(root, res);

        return res[0];
    }

    //{sum, minValue, maxValue}
    private int[] isBST(TreeNode root, int[] result) {
        if (root == null) {
            return new int[] { 0, Integer.MAX_VALUE, Integer.MIN_VALUE };
        }

        int[] leftData = isBST(root.left, result);
        int[] rightData = isBST(root.right, result);

        if (leftData[2] < root.val && rightData[1] > root.val) {
            if (leftData[0] + rightData[0] + root.val > result[0]) {
                result[0] = leftData[0] + rightData[0] + root.val;
            }
            return new int[] {
                    leftData[0] + rightData[0] + root.val,
                    Math.min(leftData[1], root.val),
                    Math.max(rightData[2], root.val)
            };
        } else {
            return new int[] { Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE };
        }
    }
}