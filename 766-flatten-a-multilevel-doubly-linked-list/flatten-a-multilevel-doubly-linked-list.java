

class Solution {
    public Node flatten(Node head) {
        return build(head);
    }

    private Node build(Node head){
        if(head == null) return null;

        Node childList = build(head.child);
        Node nextList = build(head.next);

        if(childList == null && nextList == null){
            return head;
        }

        Node childEnd = findEnd(childList);
        Node nextEnd = findEnd(nextList);

        if(childEnd  == null){
            nextList.prev = head;
            head.next = nextList;
            head.child = null;
            return head;
        }

        if(nextEnd == null){
            childList.prev = head;
            head.next = childList;
            head.child = null;
            return head;
        }

        // both child and next are not null
        head.next = childList;
        childList.prev = head;
        childEnd.next = nextList;
        nextList.prev = childEnd;
    
        head.child = null;
        return head;
    }

    private Node findEnd(Node root){
        if(root == null) return null;

        Node temp = root;
        while(temp.next != null){
            temp = temp.next;   
        }

        return temp;
    }
}



/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/