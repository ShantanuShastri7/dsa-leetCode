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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode lastNode = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return lastNode;
    }

    // public ListNode reverseList(ListNode head) {
    //     if(head==null || head.next==null) return head;
    //     ListNode prev = null;

    //     while(head.next!=null){
    //         ListNode second = head.next;
    //         head.next=prev;
    //         prev=head;
    //         head=second;
    //     }
    //     head.next=prev;
    //     return head;
    // }
}