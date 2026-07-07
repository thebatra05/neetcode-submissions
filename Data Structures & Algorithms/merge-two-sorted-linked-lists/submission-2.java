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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummyNode = new ListNode(0);
        ListNode sortedPointer = dummyNode;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                sortedPointer.next = list1;
                list1 = list1.next;
            }
            else {
                sortedPointer.next = list2;
                list2 = list2.next;
            }
            sortedPointer = sortedPointer.next;
        }

        if (list1 != null) sortedPointer.next = list1;
        if (list2 != null) sortedPointer.next = list2;

        return dummyNode.next;
    }

    /*
        head = 1
            1 -> 2 -> 4
        sp=head l1
            
            1 -> 3 -> 5
            l2


            1 -> 2 -> 4


            1 -> 3 ->
    */
}