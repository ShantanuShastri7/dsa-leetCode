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
        ListNode temp = new ListNode();
        ListNode reserve = temp;

        while (list1 != null && list2 != null) {
            System.out.print(list1.val);
            System.out.print(list2.val);
            if (list2.val <= list1.val) {
                temp.next = new ListNode(list2.val);
                temp=temp.next;
                temp.next = null;
                list2 = list2.next;
            } else {
                temp.next = new ListNode(list1.val);
                temp=temp.next;
                temp.next = null;
                list1 = list1.next;
            }
        }

        if (list1 == null) {
            while (list2 != null) {
                temp.next = new ListNode(list2.val);
                temp = temp.next;
                temp.next = null;
                list2 = list2.next;
            }
        } else if (list2 == null) {
            while (list1 != null) {
                temp.next = new ListNode(list1.val);
                temp = temp.next;
                temp.next = null;
                list1 = list1.next;
            }
        }

        return reserve.next;
    }
}