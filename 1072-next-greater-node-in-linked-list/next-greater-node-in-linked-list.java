class Solution {
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public int[] nextLargerNodes(ListNode head) {
        head = reverse(head);
        ListNode curr = head;
        int size = 0;
        while(curr != null){
            curr = curr.next;
            size++;
        }
        int ans[] = new int[size];
        size--;
        Stack<Integer> st = new Stack<>();
        curr = head;
        while(curr != null){
            while(!st.isEmpty() && st.peek() <= curr.val){
                st.pop();
            }
            if(st.isEmpty()) {
                ans[size--] = 0;
                }
            else{
                ans[size--] = st.peek();
            }
            st.push(curr.val);
            curr = curr.next;
        }
        return ans;
    }
}