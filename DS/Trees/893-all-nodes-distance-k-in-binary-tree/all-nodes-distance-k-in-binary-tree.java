/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        // Step 1: Build parent references
        buildParentMap(root, null);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);
        int dist=0;

        while (!q.isEmpty()) {
            int size = q.size();
            if (dist == k) break;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node.left != null && visited.add(node.left)) q.offer(node.left);
                if (node.right != null && visited.add(node.right)) q.offer(node.right);
                TreeNode parent = parentMap.get(node);
                if (parent != null && visited.add(parent)) q.offer(parent);
            }

            dist++;
        }

        while (!q.isEmpty()) {
            res.add(q.poll().val);
        }

        return res;
    }

    private void buildParentMap(TreeNode root, TreeNode parent){
        if(root==null) return;
        parentMap.put(root, parent);
        buildParentMap(root.left, root);
        buildParentMap(root.right, root);
    }
}