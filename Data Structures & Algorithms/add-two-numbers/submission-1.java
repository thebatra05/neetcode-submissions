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
    ListNode add(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) return null;

        int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
        carry = sum / 10;

        ListNode nextNode = add(l1 != null ? l1.next : null, l2 != null ? l2.next : null, carry);

        return new ListNode(sum % 10, nextNode);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    /*

            9 -> 9 -> 9

            1 -> 1 -> 1

        0 -> 0 -> 1 -> 1 -> 1

        d
        t

    */
}
