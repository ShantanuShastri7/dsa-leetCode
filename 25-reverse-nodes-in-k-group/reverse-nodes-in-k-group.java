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
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stackedNodes = new Stack<>();
        ListNode initialHead = head;
        ListNode result = new ListNode();
        int count = k;
        while(head!=null && count>0){
            System.out.print("pushing " + count);
            stackedNodes.push(head);
            head=head.next;
            count--;
        }
        if(count!=0 && head==null){
            System.out.print("nothig to reverse");
            return initialHead;
        } else{
            initialHead=result;
            while(!stackedNodes.isEmpty() && stackedNodes.peek()!=null){
                result.next = stackedNodes.pop();
                result=result.next;
                result.next=null;
            }
            if(head!=null){
                result.next=reverseKGroup(head, k);
            } else{
                return initialHead.next;
            }
        }
        return initialHead.next;
    }
}