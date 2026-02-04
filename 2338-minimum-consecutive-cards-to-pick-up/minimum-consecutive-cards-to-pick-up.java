class Solution {
    public int minimumCardPickup(int[] cards) {
        int n = cards.length;
        int cnt = Integer.MAX_VALUE;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            int card = cards[i];

            if(map.containsKey(card)){
                cnt = Math.min(cnt, i - map.get(card) + 1);
            }

            map.put(card, i);
        }

        return cnt == Integer.MAX_VALUE ? -1 : cnt;
    }
}