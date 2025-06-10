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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();
        ArrayList<List<Integer>> result = new ArrayList<>();

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<Tuple>();
        Tuple t = new Tuple(root, 0,0);
        q.offer(t);

        while(!q.isEmpty()){
            Tuple wt = q.poll();

            TreeNode node = wt.node;
            int x = wt.row;
            int y = wt.column;

            if(!map.containsKey(x)){
                map.put(x, new TreeMap<Integer, PriorityQueue<Integer>>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<Integer>());
            }
            map.get(x).get(y).offer(node.val);

            if(node.left!=null){
                q.offer(new Tuple(node.left, x-1, y+1));
            }
            if(node.right!=null){
                q.offer(new Tuple(node.right, x+1, y+1));
            }
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()){
            List<Integer> vs = new ArrayList<>();
            for(PriorityQueue<Integer> xs : ys.values()){
                while(!xs.isEmpty()){
                    vs.add(xs.poll());
                }
            }
            result.add(vs);
        }

        return result;
    }
}

class Tuple {
    TreeNode node;
    int row;
    int column;

    public Tuple(TreeNode node, int row, int column){
        this.node=node;
        this.row=row;
        this.column=column;
    }
}