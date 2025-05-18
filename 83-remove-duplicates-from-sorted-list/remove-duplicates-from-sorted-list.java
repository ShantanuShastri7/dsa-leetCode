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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode curr = head;

        while(head!=null){
            if(head.next!=null && head.val==head.next.val){
                ListNode nextDiff = head.next.next;

                while(nextDiff!=null && head.val==nextDiff.val){
                    nextDiff=nextDiff.next;
                }
                if(nextDiff==null){
                    head.next=null;
                    break;
                }
                head.next=nextDiff;
                head=head.next;
            } else{
                head=head.next;
            }
        }

        return curr;
    }
}