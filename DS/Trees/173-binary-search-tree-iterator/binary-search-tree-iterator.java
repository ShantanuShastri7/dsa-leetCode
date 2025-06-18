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
class BSTIterator {
    TreeNode t;
    ArrayList<Integer> inorder = new ArrayList<>();
    int index=0;
    int size=0;

    public BSTIterator(TreeNode root) {
        this.t=root;
        this.createInorder(t);
        this.size=this.inorder.size();
    }
    
    public int next() {
        return inorder.get(index++);
    }
    
    public boolean hasNext() {
        if(size>index) return true;
        else return false;
    }

    private void createInorder(TreeNode root){
        if(root==null) return;
        createInorder(root.left);
        inorder.add(root.val);
        createInorder(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */