// Focus on how temp pointer moves


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        for(int i=0; i<lists.length; i++){
            ListNode head = lists[i];
            if(head == null) continue;
            pq.offer(new Pair(head.val, head));
            lists[i] = head.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            ListNode minNode = pair.ptr;
            temp.next = minNode;
            ListNode nextNode = minNode.next;
            temp = temp.next;
            if(nextNode == null) continue;
            pq.offer(new Pair(nextNode.val, nextNode));
            minNode.next = null; 
        }

        return dummy.next;
    }
}

class Pair{
    int val ;
    ListNode ptr;

    public Pair(int val, ListNode ptr){
        this.val = val;
        this.ptr = ptr;
    }
}

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