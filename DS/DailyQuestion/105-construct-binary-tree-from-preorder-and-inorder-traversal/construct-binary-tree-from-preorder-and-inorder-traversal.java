import java.util.*;
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
        if(preorder.length==0) return null;
        if(preorder.length==1) return new TreeNode(preorder[0]);

        TreeNode result = new TreeNode(preorder[0]);
        int index = getIndex(inorder, preorder[0]);

        result.left = buildTree(Arrays.copyOfRange(preorder, 1, 1+index), Arrays.copyOfRange(inorder, 0,    
                                                                                            index));
        result.right = buildTree(Arrays.copyOfRange(preorder, 1+index, preorder.length), Arrays.copyOfRange
                                                                    (inorder, index+1, inorder.length));

        return result;
    }

    private int getIndex(int[] inorder, int node){
        int index =0;

        for(int i=0; i<inorder.length; i++){
            if(inorder[i]==node) return i;
        }
        return 0;
    }
}