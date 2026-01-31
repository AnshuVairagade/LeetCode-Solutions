class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k%2 == 0 || k%5 == 0) return -1;
        HashSet<Integer> set = new HashSet<>();
    
        int rem = 0;
        for(int i=1; i<=k; i++){
            rem = (rem *10 + 1)%k;
            if(rem == 0) return i;

            if(set.contains(rem)) return -1;
            set.add(rem);
        }

        return -1;
    }
}

// Solution : CSWM