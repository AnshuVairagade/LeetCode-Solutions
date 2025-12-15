class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;

        int ch1[] = new int[26];
        for(char ch : word1.toCharArray()) ch1[ch-'a']++;
        
        int ch2[] = new int[26];
        for(char ch : word2.toCharArray()){
            if(ch1[ch-'a'] == 0) return false;
            ch2[ch-'a']++;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<26; i++){
            if(ch1[i] == 0) continue;
            map.put(ch1[i], map.getOrDefault(ch1[i], 0)+1);
        }

        for(int i=0; i<26; i++){
            if(ch2[i] == 0) continue;
            map.put(ch2[i], map.getOrDefault(ch2[i], 0)-1);
        }

        for(int key : map.keySet()){
            if(map.get(key) != 0) return false;
        }

        return true;
    }
}

/* 
Intuition:
-----------

Occurance of Frequency of characters should be identical then only one can be transformed to another

*/