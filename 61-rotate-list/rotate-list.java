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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int len = length(head);
        k = k%len;
        if(k==0) return head;

        int cnt = 1;
        ListNode end = head;
        while(cnt < len-k){
            end = end.next;
            cnt++;
        }
        ListNode newHead = end.next;
        end.next = null;

        ListNode temp = newHead;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        return newHead;
    }

    private int length(ListNode head){
        ListNode temp = head;
        int cnt = 0;
        while(temp!= null){
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }
}