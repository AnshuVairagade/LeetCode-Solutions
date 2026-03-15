// How I removed extra space of HashSet/HashMap

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.sum - b.sum);
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<nums1.length; i++){
            pq.offer(new Pair(nums1[i]+nums2[0], i, 0));
        }
        
        while(k-- > 0){
            Pair pair = pq.poll();
            int lp = pair.lp, rp = pair.rp;

            List<Integer> temp = Arrays.asList(nums1[lp], nums2[rp]);
            res.add(temp);

            if(rp+1 < nums2.length){
                pq.offer(new Pair(nums1[lp]+nums2[rp+1], lp, rp+1));
            }
        }
    
        return res;
    }

    class Pair{
        int sum;
        int lp;
        int rp;

        public Pair(int sum, int lp, int rp){
            this.sum = sum;
            this.lp = lp;
            this.rp = rp;
        }
    }
}