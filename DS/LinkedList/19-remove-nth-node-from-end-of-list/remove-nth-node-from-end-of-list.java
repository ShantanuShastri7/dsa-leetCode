/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null && n==1) return null;

        int bleh = helper(null, head, n);
        if(bleh==-1) return head.next;
        return head;
    }

    private int helper(ListNode prevNode, ListNode node, int n){
        if(node==null) return 1;

        int count = helper(node, node.next, n);

        if(count==n){
            if(prevNode==null) return -1;
            prevNode.next=prevNode.next.next;
        }

        return count+1;
    }
}