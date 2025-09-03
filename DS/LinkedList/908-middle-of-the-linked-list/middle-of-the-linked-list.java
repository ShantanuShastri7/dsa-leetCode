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
    public ListNode middleNode(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode next = head.next;
        ListNode next2 = head.next.next;

        while(next2!=null){
            if(next2.next==null) return next;
            next=next.next;
            next2=next2.next.next;
        }

        return next;
    }
}