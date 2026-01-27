class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;

        int cnt = 0;
        for(int i=0; i<n; i++){
            // negative remainder
            int rem = ((arr[i])%k + k) % k;
            int res = k - rem;

            if(rem == 0 && map.getOrDefault(rem, 0) > 0){
                cnt++;
                map.put(rem, map.get(rem)-1);
            }
            else if(map.getOrDefault(res, 0) > 0){
                cnt++;
                map.put(res, map.get(res)-1);
            }
            else map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        System.out.println(cnt);
        return cnt == (n/2);
    }
}