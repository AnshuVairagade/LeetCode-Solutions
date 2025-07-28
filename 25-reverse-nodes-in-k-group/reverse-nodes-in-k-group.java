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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k<=1) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while(true){
            ListNode kth = prevGroupEnd;
            int cnt=0;
            while(cnt<k && kth != null){
                kth = kth.next;
                cnt++;
            }
            if(kth == null) break;

            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kth.next;
        
            kth.next = null;
            prevGroupEnd.next = null;
            reverse(groupStart);
            
            prevGroupEnd.next = kth;
            groupStart.next = nextGroupStart;
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }

    private void reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}