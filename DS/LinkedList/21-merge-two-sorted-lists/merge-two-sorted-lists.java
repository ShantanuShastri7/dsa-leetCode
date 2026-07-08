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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null) return null;
        else if(list1==null) return list2;
        else if(list2==null) return list1;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);

        pq.offer(list1);
        pq.offer(list2);
        ListNode newHead = new ListNode();
        ListNode result = newHead;

        while(!pq.isEmpty()){
            ListNode top = pq.poll();
            newHead.next=top;
            if(top.next!=null) pq.offer(top.next);
            newHead=newHead.next;

        }

        return result.next;
    }
}