class Solution {
    public int prefixConnected(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        int cnt = 0;
        for(String word : words){
            if(word.length() < k) continue;

            String prefix = word.substring(0, k);
            map.put(prefix, map.getOrDefault(prefix, 0)+1);

            if(map.get(prefix) == 2){
                cnt++;
            }
        }

        return cnt;
    }
}