// Hint 2 Builds the answer 

class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        List<Integer> list = new ArrayList<>();

        int n = obstacles.length;
        int res[] = new int[n];
        
        res[0] = 1;
        list.add(obstacles[0]);

        for(int i=1; i<n; i++){
            if(list.get(list.size()-1) <= obstacles[i]){
                list.add(obstacles[i]);
                res[i] = list.size();
            }
            else{
                int idx = upperBound(list, obstacles[i]);
                res[i] = idx+1;
                list.set(idx, obstacles[i]);
            }
        }

        return res;
    }

    private int upperBound(List<Integer> list, int k){
        int low = 0, high = list.size()-1;

        while(low <= high){
            int mid = (low + high)/2;

            if(list.get(mid) <= k){
                low = mid + 1;
            }
            else high = mid - 1;
        }

        return low;
    }
}

/* 
Approach : : LIS using BS

Monotonic Stack Trap : [3,1,5,6,4,2,7] 
*/