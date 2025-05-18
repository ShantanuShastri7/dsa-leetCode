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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Find the length of the list
        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Step 2: Make it a circular list
        current.next = head;

        // Step 3: Find the new tail (length - k % length - 1)
        k = k % length;
        int stepsToNewHead = length - k;
        ListNode newTail = current;
        while (stepsToNewHead > 0) {
            newTail = newTail.next;
            stepsToNewHead--;
        }

        // Step 4: Break the circle and return the new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
