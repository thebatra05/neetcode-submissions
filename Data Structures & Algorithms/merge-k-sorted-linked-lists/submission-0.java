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

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null;
        if (l1.val <= l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        }
        else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }

        return head;
    }
    private ListNode helper(ListNode[] lists, int start, int end) {
        if (start > end) return null;
        if (start == end) return lists[start];

        int mid = start + (end - start) / 2;
        ListNode left = helper(lists, start, mid);
        ListNode right = helper(lists, mid + 1, end);

        return mergeTwoLists(left, right);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return helper(lists, 0, lists.length - 1);
    }

    /*

        [[1, 2, 4], [1, 3, 5], [3, 6]]

        1 -> 2 -> 4

        1 -> 3 -> 5

    */
}
