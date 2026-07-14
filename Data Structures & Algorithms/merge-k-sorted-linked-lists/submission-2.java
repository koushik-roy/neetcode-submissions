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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        return mergeRange(0, lists.length - 1, lists);
    }

    public ListNode mergeRange(int left, int right, ListNode[] lists) {
        if (left == right) {
            return lists[left];
        }

        int mid = left + (right - left) / 2;

        ListNode leftMerged = mergeRange(left, mid, lists);
        ListNode rightMerged = mergeRange(mid + 1, right, lists);

        return mergeTwoLists(leftMerged, rightMerged);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 != null && l2 == null) {
            return l1;
        } else if (l2 != null && l1 == null) {
            return l2;
        }

        ListNode dummy = new ListNode(1);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                tail.next = l2;
                l2 = l2.next;
            } else {
                tail.next = l1;
                l1 = l1.next;
            }

            tail = tail.next;
        }

        if (l2 != null) {
            tail.next = l2;
        }
        if (l1 != null) {
            tail.next = l1;
        }

        return dummy.next;
    }
}
