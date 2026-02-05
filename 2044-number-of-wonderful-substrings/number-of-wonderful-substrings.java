class Solution {
    public long wonderfulSubstrings(String word) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        long cnt = 0;  // Bug point
        int xor = 0;
        for(int i=0; i<word.length(); i++){
            xor = xor ^ (1 << (word.charAt(i)-'a'));

            // even occurence
            cnt += map.getOrDefault(xor, 0);

            // odd occurence check
            for(int j=0; j<10; j++){
                int oddXor = xor ^ (1 << j);
                cnt += map.getOrDefault(oddXor, 0);
            }

            map.put(xor, map.getOrDefault(xor, 0)+1);
        }

        return cnt;
    }
}