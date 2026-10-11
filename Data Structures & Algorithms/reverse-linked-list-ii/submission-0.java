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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode curr = head; //iterator
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        curr = prev.next;

        int i = 0;
        ListNode then = curr.next;
        while (i < (right - left)) {
            curr.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = curr.next;

            i++;
        }
        return dummy.next;

    }
}