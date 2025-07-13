class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Move prev to the node before the left position
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode start = prev.next;
        ListNode then = null;

        // Reverse the sublist from left to right
        for (int i = 0; i < right - left; i++) {
            then = start.next;
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
        }

        return dummy.next;
    }
}