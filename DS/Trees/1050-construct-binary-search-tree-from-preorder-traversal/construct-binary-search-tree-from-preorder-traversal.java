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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length<1) return null;
        int[] inorder = preorder.clone();
        Arrays.sort(inorder);

        return constructTree(inorder, preorder);
    }

    private TreeNode constructTree(int[] inorder, int[] preorder){
        if(inorder.length==0 || preorder.length==0){
            return null;
        }

        int split = getIndex(preorder[0], inorder);

        TreeNode t = new TreeNode(preorder[0]);
        t.left = constructTree(Arrays.copyOfRange(inorder,0,split), Arrays.copyOfRange(preorder, 1,1+split));
        t.right = constructTree(Arrays.copyOfRange(inorder,split+1, inorder.length), Arrays.copyOfRange     
                    (preorder, 1+split, preorder.length));

        return t;
    }

    private int getIndex(int val, int [] inorder){
        for(int i=0; i<inorder.length; i++){
            if(val==inorder[i]) return i;
        }
        return 0;
    }
}