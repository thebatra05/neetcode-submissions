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

        int i = 0;
        ListNode first = dummy;
        while (i < n) {
            first = first.next;
            i += 1;
        }
        
        ListNode second = dummy;
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        if (second != null) second.next = second.next.next;
        
        return dummy.next;

    }

    /*
        n = 2   i < 1
      0 -> 1 -> 2 -> 3 -> 4 -> 5           1 -> 2 -> 3 -> 5
                s
                                f           
      0         2            
                            n = 2
                            len = 6
                            len - n - 1 
                            
    0 -> 5      n = 1
                len = 2

     t           i < 1

    */
}
