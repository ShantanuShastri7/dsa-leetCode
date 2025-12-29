/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;

        Map<Node, Node> oldToNew = new HashMap<>();
        oldToNew.put(node, new Node(node.val));

        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()){
            Node curr = q.peek();
            Node newCurr = oldToNew.get(curr);
            q.poll();

            List<Node> neigh = curr.neighbors;

            for(Node nei : neigh){
                if(!oldToNew.containsKey(nei)){
                    oldToNew.put(nei, new Node(nei.val));
                    q.offer(nei);
                }
                newCurr.neighbors.add(oldToNew.get(nei));
            }
        }
        System.out.print(oldToNew);

        return oldToNew.get(node);
    }
}














// class Solution {
//     public Node cloneGraph(Node node) {
//         if (node == null) return null;

//         Map<Node, Node> map = new HashMap<>();
//         Stack<Node> st = new Stack<>();
//         st.push(node);

//         map.put(node, new Node(node.val));

//         while (!st.isEmpty()) {
//             Node curr = st.pop();

//             for (Node neighbor : curr.neighbors) {
//                 if (!map.containsKey(neighbor)) {
//                     map.put(neighbor, new Node(neighbor.val)); 
//                     st.push(neighbor);                        
//                 }
//                 map.get(curr).neighbors.add(map.get(neighbor)); 
//             }
//         }

//         return map.get(node);
//     }
// }