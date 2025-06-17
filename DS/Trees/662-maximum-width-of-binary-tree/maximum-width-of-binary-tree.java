class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int res = 0;

        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().getValue(); // to normalize indices
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> r = q.poll();
                int index = r.getValue() - min;

                if (i == 0) first = index;
                if (i == size - 1) last = index;

                if (r.getKey().left != null) {
                    q.offer(new Pair<>(r.getKey().left, 2 * index + 1));
                }
                if (r.getKey().right != null) {
                    q.offer(new Pair<>(r.getKey().right, 2 * index + 2));
                }
            }

            res = Math.max(res, last - first + 1);
        }

        return res;
    }
}

// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public int widthOfBinaryTree(TreeNode root) {
//         if(root==null) return 0;
//         int res=0;

//         Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
//         q.offer(new Pair<>(root, 0));

//         while(!q.isEmpty()){
//             Queue<Pair<TreeNode, Integer>> sq = new LinkedList<>();
//             int min = q.peek().getValue();
//             int largest=0;
//             while(!q.isEmpty()){
//                 Pair<TreeNode, Integer> r = q.poll();
//                 if(r.getKey().left!=null) {
//                     sq.offer(new Pair<>(r.getKey().left, (r.getValue()-min)*2+1));
//                     largest=(r.getValue()-min)*2+1;
//                 }
//                 if(r.getKey().right!=null) {
//                     sq.offer(new Pair<>(r.getKey().right, (r.getValue()-min)*2+2));
//                     largest=(r.getValue()-min)*2+2;
//                 }
//             }

//             res = Math.max(res, largest);
//         }
//         return res;
        
//     }
// }

