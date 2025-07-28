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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = null;
        ListNode second = head;
        ListNode current = head;

        for (int i = 1; i < k; i++) {
            current = current.next;
        }
        first = current;

        ListNode temp = current;
        while (temp.next != null) {
            temp = temp.next;
            second = second.next;
        }


        int t = first.val;
        first.val = second.val;
        second.val = t;

        return head;
    }
}