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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length==0) return null;

        TreeNode res = new TreeNode(preorder[0]);

        int split = getIndex(preorder[0], inorder);

        res.left = buildTree(Arrays.copyOfRange(preorder, 1, 1+split), 
                    Arrays.copyOfRange(inorder, 0, split));

        res.right = buildTree(Arrays.copyOfRange(preorder, 1+split, preorder.length), 
                    Arrays.copyOfRange(inorder, 1+split, inorder.length));

        return res;
    }

    private int getIndex(int val, int[] list){
        for(int i=0; i<list.length; i++){
            if(val==list[i]) return i;
        }
        return 0;
    }
}