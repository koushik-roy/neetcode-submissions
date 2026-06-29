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
    public void reorderList(ListNode head) {
        ListNode mid = findMid(head);

        ListNode l1, l2;

        l1 = head;
        l2 = mid.next;
        mid.next = null;
        l2 = reverse(l2);

        while (l1 != null && l2 != null) {
            ListNode temp1=l1.next;
            ListNode temp2=l2.next;

            l1.next=l2;
            l2.next=temp1;

            l1=temp1;
            l2=temp2;
        }
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode findMid(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
