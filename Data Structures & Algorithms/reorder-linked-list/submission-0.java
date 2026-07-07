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
        if (head == null || head.next == null) return;
        
        // Find middle element
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow.next;
        ListNode next = curr;
        slow.next = null;
        ListNode prev = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode l1 = head;
        ListNode l2 = prev;

        while (l1 != null && l2 != null) {
            ListNode l1Next = l1.next;
            l1.next = l2;
            ListNode l2Next = l2.next;
            l2.next = l1Next;
            l1 = l1Next;
            l2 = l2Next;
        }
        
    }

    /*

        l1
        0 -> 1 -> 2 -> 3 <- 4 <- 5 <- 6
                                      l2

        0 -> 1 -> 2 -> 3   <-4 <- 5 <- 6

        l1                              l2

                       s                    c
                                      f
                                        p           n

        0 -> 6 -> 1 -> 5 -> 2 -> 4 -> 3

    */
}
