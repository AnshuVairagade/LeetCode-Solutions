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
    public boolean isPalindrome(ListNode head) {
        if(head == null) return false;
        if(head.next == null) return true;
        int len = length(head);
        int n = len/2;

        ListNode temp = head;
        for(int i=0; i<n-1; i++){
            temp = temp.next;
        }

        ListNode rev;
        if(len%2 == 0) rev = reverse(temp.next);
        else rev = reverse(temp.next.next);
        temp.next = null;

        ListNode t1 = head;
        ListNode t2 = rev;
        while(t1 != null && t2 != null){
            if(t1.val != t2.val) return false;
            t1 = t1.next;
            t2 = t2.next;
        }

        return true;
    }

    private int length(ListNode head){
        ListNode temp = head;
        int cnt = 0;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }

        return cnt;
    }

    private ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }


}