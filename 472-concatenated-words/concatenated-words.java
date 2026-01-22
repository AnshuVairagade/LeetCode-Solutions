class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashMap<String, Boolean> map = new HashMap<>();

        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        for(String word : words){
            set.add(word);
        }

        for(String word : words){
            if(isConcatinated(word, map, set)){
                res.add(word);
            }
        }

        return res;
    }

    private boolean isConcatinated(String word, HashMap<String, Boolean> map, HashSet<String> set){
        if(map.containsKey(word)){
            return map.get(word);
        } 

        for(int i=1; i<word.length(); i++){
            String prefix = word.substring(0, i);
            String suffix = word.substring(i, word.length());

            if(set.contains(prefix) && set.contains(suffix)){
                map.put(word, true);
                return true;
            }
            if(set.contains(prefix) && isConcatinated(suffix, map, set)){
                map.put(word, true);
                return true;
            }
        }

        map.put(word, false);
        return false;
    }
}

/*
Why not hashmap or hashset????


Why DP????
*/