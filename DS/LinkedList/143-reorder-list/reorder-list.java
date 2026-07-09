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
    public void reorderList(ListNode head) {
        Queue<ListNode> q = new LinkedList<>();
        ListNode result = head;

        helper(result, q, 0);

        while (!q.isEmpty()) {
            ListNode nextToNext = result.next;
            ListNode fromEnd = q.poll();

            result.next = fromEnd;

            //To break even length issues
            if (nextToNext == fromEnd) {
                fromEnd.next = null;
                break;
            }

            fromEnd.next = nextToNext;
            result = nextToNext;
        }

        if(result.next !=null && result.next.next!=null && result.next.next==result) result.next=null;
    }

    private int helper(ListNode head, Queue<ListNode> q, int count) {
        if (head == null)
            return count / 2;

        int leftToAdd = helper(head.next, q, count + 1);

        if (leftToAdd > 0)
            q.offer(head);

        return leftToAdd - 1;
    }
}