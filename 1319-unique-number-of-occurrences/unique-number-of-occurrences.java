class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        if(arr.length == 1) return true;

        HashSet<Integer> set = new HashSet<>();
        int[] freq = new int[2001];

        for(int num : arr){
            freq[num+1000]++;
        }
        
        for(int cnt : freq){
            if(set.contains(cnt)) return false;
            if(cnt != 0) set.add(cnt);
        }

        return true;
    }
}