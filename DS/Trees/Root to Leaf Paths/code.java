/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        
        inOrder(root, result, path);
        
        return result;
    }
    
    private static void inOrder(Node root,  ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path){
        if(root==null){
          return;
        }
        
        path.add(root.data);
        
        if(root.left==null && root.right==null) {
            result.add(new ArrayList<>(path));
        } else {
            inOrder(root.left, result, path);
            inOrder(root.right, result, path);
        }
        path.remove(path.size()-1);
    }
}
