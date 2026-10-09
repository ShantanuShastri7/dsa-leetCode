class Solution {
    public int amountOfTime(TreeNode root, int start) {
        TreeNodeNew rootn = new TreeNodeNew(root.val);
        rootn.parent = null;
        helper(root, rootn);

        TreeNodeNew startNode = finder(rootn, start);

        Queue<TreeNodeNew> que = new LinkedList<>();
        // 1. Create a Set to track visited node values
        Set<Integer> visited = new HashSet<>(); 

        que.offer(startNode);
        visited.add(startNode.val); // Mark start node as visited
        
        // Start at -1 because the first iteration processes the start node at minute 0
        int res = -1; 

        while(!que.isEmpty()){
            res++;
            int n = que.size();

            for(int i=0; i<n; i++){
                TreeNodeNew r = que.poll(); // Fixed typo: was q.poll()
                
                // 2. Check left child
                if(r.left != null && !visited.contains(r.left.val)){
                    visited.add(r.left.val);
                    que.offer(r.left);
                }
                // 3. Check right child
                if(r.right != null && !visited.contains(r.right.val)){
                    visited.add(r.right.val);
                    que.offer(r.right);
                }
                // 4. Check parent! (This is why you built TreeNodeNew)
                if(r.parent != null && !visited.contains(r.parent.val)){
                    visited.add(r.parent.val);
                    que.offer(r.parent);
                }
            }
        }
        
        return res;
    }

    private TreeNodeNew finder(TreeNodeNew root, int start){
        if(root==null) return null;
        if(root.val == start) return root;

        TreeNodeNew resl = finder(root.left, start);
        if(resl!=null) return resl; // Short-circuit if found in left subtree
        
        TreeNodeNew resr = finder(root.right, start);
        if(resr!=null) return resr;

        return null;
    }

    private void helper(TreeNode root, TreeNodeNew rootn){
        if(root==null) return;

        if(root.left!=null){
            rootn.left = new TreeNodeNew(root.left.val);
            rootn.left.parent = rootn;
        }

        if(root.right!=null){
            rootn.right = new TreeNodeNew(root.right.val);
            rootn.right.parent = rootn;
        }

        helper(root.left, rootn.left);
        helper(root.right, rootn.right);
    }

    public class TreeNodeNew {
      int val;
      TreeNodeNew left;
      TreeNodeNew right;
      TreeNodeNew parent;
      TreeNodeNew() {}
      TreeNodeNew(int val) { this.val = val; }
      TreeNodeNew(TreeNodeNew left, TreeNodeNew right, TreeNodeNew parent) {
          this.left = left;
          this.right = right;
          this.parent = parent;
        } 
    }
}