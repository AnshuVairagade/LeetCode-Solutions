// Why to use HashMap??

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> res = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.sum - b.sum);

        HashSet<String> visited = new HashSet<>();

        pq.offer(new Pair(nums1[0] + nums2[0], 0, 0));
        visited.add("0,0");

        while(k > 0 && !pq.isEmpty()){

            Pair pair = pq.poll();
            int lp = pair.lp;
            int rp = pair.rp;

            res.add(Arrays.asList(nums1[lp], nums2[rp]));

            if(lp + 1 < nums1.length){
                String key = (lp+1) + "," + rp;
                if(!visited.contains(key)){
                    pq.offer(new Pair(nums1[lp+1] + nums2[rp], lp+1, rp));
                    visited.add(key);
                }
            }

            if(rp + 1 < nums2.length){
                String key = lp + "," + (rp+1);
                if(!visited.contains(key)){
                    pq.offer(new Pair(nums1[lp] + nums2[rp+1], lp, rp+1));
                    visited.add(key);
                }
            }

            k--;
        }

        return res;
    }

    class Pair{
        int sum;
        int lp;
        int rp;

        Pair(int sum, int lp, int rp){
            this.sum = sum;
            this.lp = lp;
            this.rp = rp;
        }
    }
}