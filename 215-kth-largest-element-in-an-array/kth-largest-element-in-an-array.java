class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();

        for(int num : nums){
            min_heap.add(num);
            if(min_heap.size() > k) {
                int rem = min_heap.poll();
            }
        }

        return min_heap.peek();
    }
}