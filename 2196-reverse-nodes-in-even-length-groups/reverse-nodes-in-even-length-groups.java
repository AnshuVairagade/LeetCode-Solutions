/**
Edge Case helped me draft the solution

 Using 3 - pointer approach :
 prevGroupEnd, currGroupStart, nextGroupStart

 for each group count nodes 
 1) Even length group
 2) Odd length group

*/

class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode prev = head;
        ListNode currHead = prev.next;
        int group = 1;

        while(currHead != null){
            group++;
            int cnt = 0, nodes = 1;

            ListNode temp = currHead;
            while(temp.next != null && cnt < group-1){
                temp = temp.next; cnt++; nodes++;
            }

            if(nodes%2 != 0){
                prev = temp;
                currHead = temp.next;
                continue;
            }

            ListNode nextNode = temp.next;
            prev.next = null;
            temp.next = null;
            ListNode revHead = reverse(currHead);

            prev.next = revHead;
            currHead.next = nextNode; 

            prev = currHead;
            currHead = nextNode;
        }
    
        return head;
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