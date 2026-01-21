class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = 0;
        int mask = 0;

        map.put(0, -1);
        for(int i=0; i<s.length(); i++){
            mask = getMask(mask, s.charAt(i));

            if(map.containsKey(mask)){
                len = Math.max(len, i-map.get(mask));
            }
            else map.put(mask, i);
        }

        return len;
    }

    private int getMask(int mask, char ch){
        if(ch == 'a') mask = mask ^ (1 << 0);
        if(ch == 'e') mask = mask ^ (1 << 1);
        if(ch == 'i') mask = mask ^ (1 << 2);
        if(ch == 'o') mask = mask ^ (1 << 3);
        if(ch == 'u') mask = mask ^ (1 << 4);

        return mask;
    }
}