/**
 */
class Solution {
    public int pairSum(ListNode head) {
        if(head == null) return 0;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode nextHead = slow.next;
        slow.next = null;

        ListNode revHead = reverse(nextHead);
        int sum = 0;

        ListNode temp1 = head;
        ListNode temp2 = revHead;
        while(temp1 != null && temp2 != null){
            sum = Math.max(sum, temp1.val + temp2.val);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return sum;
    }

    private ListNode reverse(ListNode head){
        if(head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head, next; 

        while(curr != null){
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }
}