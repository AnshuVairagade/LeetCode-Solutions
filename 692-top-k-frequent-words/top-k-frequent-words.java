class Solution {
    class Pair{
        int cnt;
        String word;
        
        Pair(int cnt, String word){
            this.cnt = cnt;
            this.word = word;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2)->{
            if(p1.cnt == p2.cnt){
                return p2.word.compareTo(p1.word);
            }
            return p1.cnt - p2.cnt;
        });

        for(String word : words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        for(String word : map.keySet()){
            Pair pair = new Pair(map.get(word), word);
            pq.add(pair);
            if(pq.size() > k){
                Pair p = pq.poll();
            }
        }

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            ans.add(p.word);
        }

        Collections.reverse(ans);
        
        return ans;
    }
}