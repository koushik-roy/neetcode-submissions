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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next=head; //assign dummy
        ListNode groupPrev = dummy;
        while (groupPrev.next != null) {  //loop
            ListNode kNode = getK(groupPrev, k);  //get kth node
            if (kNode == null) {
                break; 
            }

            ListNode groupNext = kNode.next;  //pointer to next group head
            ListNode groupHead = groupPrev.next;  //pointer to current group head
            ListNode newHead = reverse(groupPrev.next, groupNext); //reverse the group and store the new head 

            //reconnect to parent list
            groupPrev.next = newHead;
            groupPrev=groupHead;
        }
        return dummy.next;
    }

    public ListNode getK(ListNode groupPrev, int k) {
        ListNode itr = groupPrev;
        for (int i = 0; i < k; i++) {
            if (itr == null) {
                return null;
            }
            itr = itr.next;
        }
        return itr;
    }

    public ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = end;
        ListNode curr = start;
        ListNode next;

        while (curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
