class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        HashMap<Long, Long> map = new HashMap<>();
        int n = nums.size();
        long m = modulo * 1L;

        int arr[] = new int[n];
        for(int i=0; i<n; i++) arr[i] = nums.get(i) % modulo == k ? 1 : 0;

        long cnt = 0L;
        map.put(0L, 1L);
        long s1 = 0L;
        for(int i=0; i<n; i++){
            // s1 += (arr[i] * 1L);
            s1 =  s1 + (nums.get(i) % modulo == k ? 1 : 0);
        
            long r1 = s1 % m;
            long r2 = (r1 - k + m) % m;

            cnt += map.getOrDefault(r2, 0L);

            map.put(r1, map.getOrDefault(r1, 0L)+1);
        }

        return cnt;
    }
}


/*

To calculate count of element define the arr that stores whether (nums[i]%m) == k

        s1
___________
[a,b,c,d,e,f,g]
______------
(s2)  (s1-s2)%m == k


 
Question demands (s1 - s2) % m = k

(s1 - s2 ) % m = k,     It means 
(s1 - s2 - k) % m = 0,   we have s1 and k just find the s2

(r1 - r2 - k + m) % m = 0

(r1 - k + m) % m = r2

if r2 was found previously means (s1-s2) % m == k is found

Then use the prefixSum + hashing


Solution : https://www.youtube.com/watch?v=MTQWe8qHcz0
*/

