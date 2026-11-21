/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

function reverseKGroup(head: ListNode | null, k: number): ListNode | null {
    const stack = [];
    let l = head;
    for(let i=0; i<k; i++){
        if(l == null){
            return head;
        }else{
            stack.push(l);
            l=l.next;
        }
    }
    const newHead = stack.pop();
    const nextFuncCall = newHead.next;
    let prev = newHead;
    while(stack.length>0){
        let nxt = stack.pop();
        prev.next = nxt;
        prev = prev.next;
    }

    const nextInLine = reverseKGroup(nextFuncCall, k);
    prev.next = nextInLine;

    return newHead;
};