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
    public ListNode removeNodes(ListNode head) {
        if(head==null) return null;

        int last = returnLargest(head,head.next);

        if(last>head.val){
            return head.next;
        }

        return head;
    }

    private int returnLargest(ListNode prev, ListNode head){
        if(head.next==null) return head.val;

        int largestToRight = returnLargest(head,head.next);
        if(largestToRight>head.val){
            prev.next=head.next;
        } else {
            largestToRight = head.val;
        }
        return largestToRight;
    }
}