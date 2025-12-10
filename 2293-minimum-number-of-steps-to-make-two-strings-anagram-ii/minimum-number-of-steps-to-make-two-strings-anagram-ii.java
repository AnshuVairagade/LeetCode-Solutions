class Solution {
    public int minSteps(String s, String t) {
        int fs[] = new int[26];
        int ft[] = new int[26];

        for(int ch : s.toCharArray()) fs[ch-'a']++;
        for(int ch : t.toCharArray()) ft[ch-'a']++;

        int cnt = 0;
        for(int i=0; i<26; i++) cnt += Math.abs(fs[i] - ft[i]);

        return cnt;
    }
}