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
        if(head==null) return null;
        int count = removeNode(head, n);
        if(count==n) return head.next;
        else return head;
    }

    private int removeNode(ListNode head, int nodeFromEnd){
        if(head.next==null){
           return 1; 
        }

        int nodeCount = removeNode(head.next, nodeFromEnd);
        System.out.print("nodeFromEnd " + nodeFromEnd);
        System.out.print("count " + nodeCount);
        if(nodeCount==nodeFromEnd) {
            head.next=head.next.next;
        }
        nodeCount++;
        return nodeCount;
    }
}