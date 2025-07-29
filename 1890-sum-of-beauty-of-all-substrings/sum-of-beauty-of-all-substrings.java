class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int cnt = 0;

        for(int i=0; i<n; i++){
            int freq[] = new int[26];
            for(int j=i; j<n; j++){
                freq[s.charAt(j)-'a']++;
                int max = findMax(freq);
                int min = findMin(freq);
                cnt += max-min;
            }
        }

        return cnt;
    }

    private int findMax(int freq[]){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<26; i++) max = Math.max(max, freq[i]);
        return max;
    }

    private int findMin(int freq[]){
        int min = Integer.MAX_VALUE;
        for(int i=0; i<26; i++){
            if(freq[i] != 0)  min = Math.min(min, freq[i]);
        }
        return min;
    }
}