class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums1.length;
        long maxScore = 0L;

        int nums[][] = new int[n][2]; 
        for(int i=0; i<n; i++){
            nums[i][0] = nums1[i];
            nums[i][1] = nums2[i];
        }

        Arrays.sort(nums, (a,b)->b[1]-a[1]);

        long sum = 0;
        for(int i=0; i<k-1; i++){
            sum += nums[i][0];
            pq.offer(nums[i][0]);
        }

        for(int i=k-1; i<n; i++){
            sum += nums[i][0];
            pq.offer(nums[i][0]);

            long score = sum * nums[i][1];
            maxScore = Math.max(maxScore, score);
        
            sum -= pq.poll();
        }

        return maxScore;
    }
}