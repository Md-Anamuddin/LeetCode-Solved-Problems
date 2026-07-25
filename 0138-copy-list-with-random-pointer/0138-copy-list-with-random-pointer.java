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
    public Node deepCopy(Node head){
        Node t1 = head;
        Node d = new Node(-1);
        Node t2 = d;
        while(t1!=null){
            Node t = new Node(t1.val);
            t2.next = t;
            t2 = t;
            t1 = t1.next; 
        }
        return d.next;
    }

    public void merge(Node head1, Node head2){
        Node t1 = head1;
        Node t2 = head2;
        Node d = new Node(-1);
        Node t = d;
        while(t1!=null && t2!=null){
            t.next = t1;
            t = t1;
            t1 = t1.next;

            t.next = t2;
            t = t2;
            t2 = t2.next;
        }
    }

    public void randomConnection(Node head1, Node head2){
        Node t1 = head1;
        Node t2 = head2;
        while(t1!=null && t2!=null){
            if(t1.random==null) t2.random=null;
            else t2.random = t1.random.next;
            t1 = t1.next.next;
            if(t2.next!=null) t2 = t2.next.next;
        }
    }

    public void split(Node head1){
        Node d1 = new Node(-1);
        Node t1 = d1;
        Node d2 = new Node(-1);
        Node t2 = d2;
        Node t = head1;
        while(t!=null){
            t1.next = t;
            t = t.next;
            t1 = t1.next;

            t2.next = t;
            t = t.next;
            t2 = t2.next;
        }
        t1.next = null;
    }
    public Node copyRandomList(Node head1) {
        //Step 1: Create deep copy of given list
        Node head2 = deepCopy(head1);

        //Step 2: Alternatively connecting given list and copied list
        merge(head1, head2);

        //Step 3: Assigning random pointer
        randomConnection(head1, head2);

        //Step 4: Split the list
        split(head1);

        return head2;
    }
}