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

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            }
            else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        if (l1 != null) temp.next = l1;
        if (l2 != null) temp.next = l2;

        return dummy.next;
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
