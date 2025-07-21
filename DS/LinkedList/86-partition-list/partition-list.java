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
    public ListNode partition(ListNode head, int x) {
        if(head==null) return null;
        ListNode less = new ListNode();
        ListNode greater = new ListNode();
        ListNode greatStart = greater;
        ListNode smallStart = less;

        while(head!=null){
            if(head.val<x){
                less.next=new ListNode(head.val, null);
                less=less.next;
            } else {
                greater.next=new ListNode(head.val, null);
                greater=greater.next;
            }
            head=head.next;
        }

        less.next=greatStart.next;

        return smallStart.next;
    }
}