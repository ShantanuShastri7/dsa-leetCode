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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode result = new ListNode(0);
        ListNode res = result;
        while(l1!=null || l2!=null){
            if(l1!=null && l2!=null){
                int sum = l1.val+l2.val+carry;
                carry=sum/10;
                sum=sum%10;
                result.next = new ListNode(sum);
                result=result.next;
                l1=l1.next; l2=l2.next;
            } else if(l1!=null){
                int sum = l1.val+carry;
                carry=sum/10;
                sum=sum%10;
                result.next = new ListNode(sum);
                result=result.next;
                l1=l1.next;
            } else {
                int sum = l2.val+carry;
                carry=sum/10;
                sum=sum%10;
                result.next = new ListNode(sum);
                result=result.next;
                l2=l2.next;
            }
        }

        if(carry!=0){
            result.next = new ListNode(carry);
        }


        return res.next;
    }
}