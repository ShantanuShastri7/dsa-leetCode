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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null) return null;

        ListNode result = new ListNode();
        ListNode curr=result;
        int index=0;
        Stack<ListNode> stack = new Stack<>();

        while(head!=null && index<left-1){
            result.next=new ListNode(head.val);
            head=head.next;
            result=result.next;
            index++;
        }
        while(head!=null && index<right){
            index++;
            stack.push(head);
            head=head.next;
        }

        while(!stack.isEmpty()){
            result.next=new ListNode(stack.pop().val);
            result=result.next;
        }

        while(head!=null){
            result.next=new ListNode(head.val);
            result=result.next;
            head=head.next;
        }

        return curr.next;
    }
}