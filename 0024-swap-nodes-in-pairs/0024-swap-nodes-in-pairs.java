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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode d1 = new ListNode(-1);
        ListNode d2 = new ListNode(-1);
        ListNode t1 = d1;
        ListNode t2 = d2;
        ListNode t = head;
        while(t!=null && t.next!=null){
            t1.next = t;
            t = t.next;
            t1 = t1.next;

            t2.next = t;
            t = t.next;
            t2 = t2.next;
        }
        if(t!=null){
            t1.next = t;
            t = t.next;
            t1 = t1.next;
        }
        t1.next = null;
        t2.next = null;

        ListNode ans = new ListNode(-1);
        ListNode p = ans;
        t1 = d1.next;
        t2 = d2.next;
        while(t1!=null && t2!=null){
            p.next = t2;
            t2 = t2.next;
            p = p.next;
            p.next = t1;
            t1 = t1.next;
            p = p.next;
        }
        if(t1==null){
            while(t2!=null){
                p.next = t2;
                t2 = t2.next;
                p = p.next;
            }
        }

        if(t2==null){
            while(t1!=null){
                p.next = t1;
                t1 = t1.next;
                p = p.next;
            }
        }
        return ans.next;
    }
}