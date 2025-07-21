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
    public ListNode insertionSortList(ListNode head) {
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode curr=result;

        while(head!=null){
            curr=result;
            ListNode prev=curr;
            while(curr!=null){
                if(curr.val<=head.val){
                    prev=curr;
                    curr=curr.next;
                } else{
                    break;
                }
            }
            prev.next=new ListNode(head.val, curr);
            head=head.next;
        }

        return result.next;
    }
}