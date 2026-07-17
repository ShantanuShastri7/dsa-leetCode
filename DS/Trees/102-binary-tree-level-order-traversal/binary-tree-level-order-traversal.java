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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();

        Queue<TreeNode> fq = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        fq.offer(root);

        while(!fq.isEmpty()){
            int fqSize = fq.size();
            Queue<TreeNode> sq = new LinkedList<>();

            ArrayList<Integer> res = new ArrayList<>();
            for(int i=0; i<fqSize; i++){
                TreeNode t = fq.poll();
                res.add(t.val);
                if(t.left!=null) sq.offer(t.left);
                if(t.right!=null) sq.offer(t.right);
            }
            fq=sq;
            result.add(res);
        }

        return result;
    }
}