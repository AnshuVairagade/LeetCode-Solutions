class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) ->{
            if(a.dis == b.dis){
                return a.val - b.val;
            }
            return a.dis - b.dis;
        });

        for(int el : arr){
            int dis = Math.abs(el - x);
            pq.offer(new Pair(el, dis));
        }

        List<Integer> list = new ArrayList<>();
        while(!pq.isEmpty() && k>0){
            Pair pair = pq.poll();
            list.add(pair.val);
            k--;
        }

        Collections.sort(list);
        return list;
    }
}

class Pair{
    int val;
    int dis;

    Pair(int val, int dis){
        this.val = val;
        this.dis = dis;
    }
}