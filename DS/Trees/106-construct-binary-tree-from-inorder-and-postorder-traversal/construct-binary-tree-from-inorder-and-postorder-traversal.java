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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0) return null;

        TreeNode res = new TreeNode(postorder[postorder.length-1]);

        int split = getIndex(postorder[postorder.length-1], inorder);

        res.left = buildTree(Arrays.copyOfRange(inorder, 0, split), Arrays.copyOfRange(postorder, 0, split));

        res.right = buildTree(Arrays.copyOfRange(inorder, split+1, inorder.length), 
                                Arrays.copyOfRange(postorder, split, postorder.length-1));

        return res;
    }

    private int getIndex(int val, int[] list){
        for(int i=0; i<list.length; i++){
            if(val==list[i]) return i;
        }
        return 0;
    }
}