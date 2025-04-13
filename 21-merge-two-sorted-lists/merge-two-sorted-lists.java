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
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1 == null && list2 == null)
            return null;

        if(list2.val<=list1.val){
            ListNode prev = list2;
            ListNode curr = list2;
            
            while (list1!=null&&curr!=null) {
                if(curr.val<=list1.val) {
                    prev=curr;
                    curr=curr.next;
                } else {
                    prev.next = new ListNode(list1.val, curr);
                    prev=prev.next;
                    list1=list1.next;
                }
            }

            if(curr==null) {
                while(list1!=null) {
                    prev.next = new ListNode(list1.val);
                    prev=prev.next;
                    list1=list1.next;
                }
            }

            return list2;
        } else {
            ListNode prev = list1;
            ListNode curr = list1;
            
            while(curr!=null&&list2!=null) {
                if(curr.val<=list2.val) {
                    prev=curr;
                    curr=curr.next;
                } else {
                    prev.next = new ListNode(list2.val, curr);
                    prev=prev.next;
                    list2=list2.next;
                }
            }

            if(curr==null) {
                while(list2!=null) {
                    prev.next = new ListNode(list2.val);
                    prev=prev.next;
                    list2=list2.next;
                }
            }

            return list1;
        }
    }
}