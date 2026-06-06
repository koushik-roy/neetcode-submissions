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
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode prv=null;
        ListNode curr=head;
        ListNode nxt;

        
        while(curr!=null){
            nxt=curr.next; 
            curr.next=prv; 
            prv=curr; 
            curr=nxt; 
        }

        return prv;
    }
}
