// Using hashmap to store frequency
// Using priority queue to get min frequency
// Remove element with less frequnecyn one by one

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue()); // min_heap
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(entry);
        }

        while(!pq.isEmpty() && k>0){
            Map.Entry<Integer, Integer> entry = pq.poll();
            int cnt = entry.getValue();
            cnt--;
            entry.setValue(cnt);
            if(cnt > 0) pq.offer(entry);
            k--;
        }

        return pq.size();
    }
}