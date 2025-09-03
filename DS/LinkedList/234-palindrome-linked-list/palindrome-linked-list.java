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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;

        Stack<ListNode> s = new Stack<>();
        ListNode initialHead = head;
        while(head!=null) {
            s.push(head);
            head=head.next;
        }

        while(!s.isEmpty()){
            if(s.pop().val!=initialHead.val) return false;
            else{
                initialHead=initialHead.next;
            }
        }

        return true;
    }
}