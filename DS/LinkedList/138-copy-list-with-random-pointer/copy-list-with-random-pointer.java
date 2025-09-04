/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return head;

        Node temp=head;

        while(temp!=null){
            Node weave = new Node(temp.val);
            weave.next=temp.next;
            temp.next=weave;
            temp=temp.next.next;
        }

        temp=head;

        while(temp!=null){
            Node weaved = temp.next;
            weaved.random = (temp.random != null) ? temp.random.next : null;
            temp=temp.next.next;
        }

        Node newHead = head.next;
        Node original = head;
        Node copy = newHead;

        while (original != null) {
            original.next = original.next.next;
            copy.next = (copy.next != null) ? copy.next.next : null;

            original = original.next;
            copy = copy.next;
        }

        return newHead;
    }
}