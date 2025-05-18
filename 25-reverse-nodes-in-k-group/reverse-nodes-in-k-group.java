// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public ListNode reverseKGroup(ListNode head, int k) {
//         Stack<ListNode> stackedNodes = new Stack<>();
//         ListNode initialHead = head;
//         ListNode result = new ListNode();
//         int count = k;
//         while(head!=null && count>0){
//             stackedNodes.push(head);
//             head=head.next;
//             count--;
//         }
//         if(count!=0 && head==null){
//             return initialHead;
//         } else{
//             initialHead=result;
//             while(!stackedNodes.isEmpty() && stackedNodes.peek()!=null){
//                 result.next = stackedNodes.pop();
//                 result=result.next;
//                 result.next=null;
//             }
//             if(head!=null){
//                 result.next=reverseKGroup(head, k);
//             } else{
//                 return initialHead.next;
//             }
//         }
//         return initialHead.next;
//     }
// }

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(0); // Dummy node before the result
        ListNode prevTail = dummy;

        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr;
            int count = 0;

            // Push up to k nodes onto the stack
            while (temp != null && count < k) {
                stack.push(temp);
                temp = temp.next;
                count++;
            }

            // If we have fewer than k nodes, don't reverse
            if (count < k) {
                prevTail.next = curr;
                break;
            }

            // Pop from stack to reverse the group
            while (!stack.isEmpty()) {
                prevTail.next = stack.pop();
                prevTail = prevTail.next;
            }

            // Link to the rest of the list
            prevTail.next = temp;
            curr = temp;
        }

        return dummy.next;
    }
}
