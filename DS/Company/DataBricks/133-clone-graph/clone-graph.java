class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Stack<Node> st = new Stack<>();
        st.push(node);

        map.put(node, new Node(node.val));

        while (!st.isEmpty()) {
            Node curr = st.pop();

            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val)); 
                    st.push(neighbor);                        
                }
                map.get(curr).neighbors.add(map.get(neighbor)); 
            }
        }

        return map.get(node);
    }
}
