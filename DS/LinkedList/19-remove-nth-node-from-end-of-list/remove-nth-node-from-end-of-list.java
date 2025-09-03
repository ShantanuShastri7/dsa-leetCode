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
        
        ListNode dummy = new ListNode(0, head); 
        removeNode(dummy, head, n);
        return dummy.next;
    }

    private int removeNode(ListNode prev, ListNode current, int n){
        if(current==null) return 1;

        int fromLast = removeNode(current, current.next, n);
        if(fromLast==n){
            if(prev==null){
                current=current.next;
            } else {
                prev.next=current.next;
            }
        }

        return fromLast+1;
    }
}