class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();        // number of nodes in this level
            Node prev = null;

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                if (prev != null) prev.next = curr;
                prev = curr;

                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }

            prev.next = null;
        }

        return root;
    }
}