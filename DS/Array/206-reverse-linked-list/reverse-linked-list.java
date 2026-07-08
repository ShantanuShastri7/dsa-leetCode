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

        return helper(head , null);
    }

    private ListNode helper(ListNode head, ListNode prevHead){
        if(head.next==null) {
            head.next=prevHead;
            return head;
        }

        ListNode nextHead = head.next;
        head.next=prevHead;

        return helper(nextHead, head);
    }
}