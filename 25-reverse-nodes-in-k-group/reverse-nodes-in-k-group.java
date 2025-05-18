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
