/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        if (node == null) return result;

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> li = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        result.add(node.data);

        if (node.left != null) getLeftBoundary(node.left, q);

        getLeaf(node.left, li);
        getLeaf(node.right, li);

        if (node.right != null) getRightBoundary(node.right, st);

        while (!q.isEmpty()) {
            result.add(q.poll());
        }

        for (Integer i : li) {
            result.add(i);
        }

        while (!st.isEmpty()) {
            result.add(st.pop());
        }

        return result;
    }

    private void getLeftBoundary(Node node, Queue<Integer> q) {
        if (node.left == null && node.right == null) return; 

        q.offer(node.data);

        if (node.left != null) getLeftBoundary(node.left, q);
        else getLeftBoundary(node.right, q); 
    }


    private void getLeaf(Node node, ArrayList<Integer> li) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            li.add(node.data);
            return;
        }
        getLeaf(node.left, li);
        getLeaf(node.right, li);
    }


    private void getRightBoundary(Node node, Stack<Integer> st) {
        if (node.left == null && node.right == null) return; 

        st.push(node.data);

        if (node.right != null) getRightBoundary(node.right, st);
        else getRightBoundary(node.left, st); 
    }
}
