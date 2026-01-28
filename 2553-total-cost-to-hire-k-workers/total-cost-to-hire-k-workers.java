// Edge cases are important -> overlap handling

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> leftPQ = new PriorityQueue<>();
        PriorityQueue<Integer> rightPQ = new PriorityQueue<>();

        int n = costs.length;

        int leftIdx = 0, cnt = 0;
        while(leftIdx < n && cnt<candidates){
            leftPQ.offer(costs[leftIdx]);
            leftIdx++; cnt++;
        }

        int rightIdx = n-1; cnt = 0;  // bug point
        while(leftIdx <= rightIdx && cnt<candidates){
            rightPQ.offer(costs[rightIdx]);
            rightIdx--; cnt++;
        } 

        long totalCost = 0;
        while(k > 0){
            if(rightPQ.isEmpty() || (!leftPQ.isEmpty() && 
                leftPQ.peek() <= rightPQ.peek())){
                totalCost += leftPQ.poll();
                if(leftIdx <= rightIdx){
                    leftPQ.offer(costs[leftIdx]);
                    leftIdx++;
                }
            }
            else { // rightPQ.isEmpty() 
                totalCost += rightPQ.poll();
                if(leftIdx <= rightIdx){
                    rightPQ.offer(costs[rightIdx]);
                    rightIdx--;
                }
            }         

            k--;
        }

        return totalCost;
    }

}

/*
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        boolean used[] = new boolean[n];

        long totalCost = 0;
        while(k > 0){
            int minLeft = Integer.MAX_VALUE;
            int cnt = 0, idx = 0;
            while(cnt<candidates && idx<n ){
                if(!used[idx]){
                    minLeft = Math.min(idx, minLeft);
                    cnt++; 
                }
                idx++;
            }

            int minRight = Integer.MAX_VALUE;
            cnt = 0; idx = n-1;
            while(cnt<candidates && idx>=0){
                if(!used[idx]){
                    minRight = Math.min(idx, minRight);
                    cnt++;
                }
                idx--;
            }

            System.out.println(minLeft+" "+minRight);

            if(costs[minLeft] < costs[minRight]){
                totalCost += costs[minLeft];
                used[minLeft] = true;
            }
            else{
                totalCost += costs[minRight];
                used[minRight] = true;
            }

            k--;
        }

        return totalCost;
    }
}
*/