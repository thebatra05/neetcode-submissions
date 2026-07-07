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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int sum = 0, carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            l1 = (l1 != null ? l1.next : null);
            l2 = (l2 != null ? l2.next : null);
            temp = temp.next;
        }

        return dummy.next;
    }

    /*

            9 -> 9 -> 9

            1 -> 1 -> 1

        0 -> 0 -> 1 -> 1 -> 1

        d
        t

    */
}
