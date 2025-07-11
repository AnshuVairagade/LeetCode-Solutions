class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            int cnt[] = new int[26];
            for(char ch : str.toCharArray()){
                cnt[ch-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<26; i++){
                char[] t = new char[cnt[i]];
                Arrays.fill(t, (char)(i+'a'));
                sb.append(new String(t));
            }
            String p = sb.toString();
            if(!map.containsKey(p)){
                map.put(p, new ArrayList<>());
            }
            map.get(p).add(str);
        }

        return new ArrayList<>(map.values());
    }
}