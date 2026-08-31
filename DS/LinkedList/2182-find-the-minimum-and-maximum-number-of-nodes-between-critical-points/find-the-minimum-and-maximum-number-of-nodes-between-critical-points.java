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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) return new int[]{-1,-1};

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;

        int minDist = Integer.MAX_VALUE;
        ArrayList<Integer> res = new ArrayList<>();
        int index=0;

        while(next!=null){
            if(prev.val<curr.val && curr.val>next.val){
                res.add(index);
            }

            if(prev.val>curr.val && curr.val<next.val){
                res.add(index);
            }

            if(res.size()>1){
                minDist = Math.min(minDist, index-res.get(res.size()-2));
            }

            prev=curr;
            curr=next;
            next=next.next;
            index++;
        }
        int maxDist =-1;
        if(res.size()>1){
            maxDist = res.get(res.size()-1)-res.get(0);
        }else minDist = -1;

        return new int[]{minDist, maxDist};
    }
}