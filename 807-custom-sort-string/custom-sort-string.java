class Solution {
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();

        int freq[] = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }

        for(char ch : order.toCharArray()){
            int cnt = freq[ch-'a'];
            for(int i=0; i<cnt; i++) sb.append(ch);
            freq[ch-'a'] = 0;
        }

        for(char ch : s.toCharArray()){
            int cnt = freq[ch-'a'];
            for(int i=0; i<cnt; i++) sb.append(ch);
            freq[ch-'a'] = 0;
        }

        return sb.toString();
    }
}