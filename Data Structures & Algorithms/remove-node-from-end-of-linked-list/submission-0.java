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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;

        ListNode dummy = new ListNode(0, head);

        int len = 0;
        ListNode temp = dummy;
        while (temp != null) {
            temp = temp.next;
            len += 1;
        }

        int i = 0;
        temp = dummy;
        while (i < len - n - 1 && temp != null) {
            temp = temp.next;
            i += 1;
        }

        if (temp != null) temp.next = temp.next.next;
        
        return dummy.next;

    }

    /*

      0 -> 1 -> 2 -> 3 -> 4 -> 5           1 -> 2 -> 3 -> 5

                            n = 2
                            len = 6
                            len - n - 1 
                            
    0 -> 5      n = 1
                len = 2

     t           i < 1

    */
}
