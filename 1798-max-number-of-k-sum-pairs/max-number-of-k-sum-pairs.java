class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int del = 0;
        for(int num : nums){
            int dif = k - num;
            
            if(map.containsKey(dif) && map.get(dif) > 0){
                map.put(dif, map.get(dif)-1);
                del++;
            }
            else map.put(num, map.getOrDefault(num, 0)+1);
        }

        return del;
    }
}

/*

a[0] + a[3] = 5

a[0] = 5 - a[3]

map(a[0])--;

[1,2,3,4,4,5]      k = 5


1 -> 0 
2 -> 0
4 -> 1

*/