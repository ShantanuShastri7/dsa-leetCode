class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        boolean leftToRight = true;

        while (!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                if (leftToRight) {
                    // Pop from FRONT
                    TreeNode node = dq.pollFirst();
                    level.add(node.val);

                    // Add children LEFT → RIGHT at BACK
                    if (node.left != null) dq.offerLast(node.left);
                    if (node.right != null) dq.offerLast(node.right);
                } else {
                    // Pop from BACK
                    TreeNode node = dq.pollLast();
                    level.add(node.val);

                    // Add children RIGHT → LEFT at FRONT
                    if (node.right != null) dq.offerFirst(node.right);
                    if (node.left != null) dq.offerFirst(node.left);
                }
            }

            result.add(level);
            leftToRight = !leftToRight; // Flip the direction for the next level
        }

        return result;
    }
}
