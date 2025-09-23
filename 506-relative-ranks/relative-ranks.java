class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            maxHeap.add(score[i]);
            map.put(score[i], i);
        }

        String ans[] = new String[n];
        int cnt = 1;
        while(!maxHeap.isEmpty()){
            int val = maxHeap.poll();
            int idx = map.get(val);
            if(cnt == 1){
                ans[idx] = "Gold Medal";
            }
            else if(cnt == 2){
                ans[idx] = "Silver Medal";
            }
            else if(cnt == 3){
                ans[idx] = "Bronze Medal";
            }
            else{
                ans[idx] = ""+cnt;
            }
            cnt++;
        }

        return ans;
    }
}