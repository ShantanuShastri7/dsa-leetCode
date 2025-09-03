/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode baseA = headA;
        ListNode baseB = headB;

        while(headA!=null){
            while(headB!=null){
                if(headA==headB) return headA;
                else headB=headB.next;
            }
            headA=headA.next;
            headB=baseB;
        }

        return null;
    }
}