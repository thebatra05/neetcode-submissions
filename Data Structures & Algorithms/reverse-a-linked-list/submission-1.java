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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }

    /*

           0 -> 1 <- 2 <- 3
        
            p,  c
                n

                2 <- 3
                head p

            nextNode = curr->next;
            curr->next = prevNode
            prevNode = curr
            curr = nextNode
    */
}
