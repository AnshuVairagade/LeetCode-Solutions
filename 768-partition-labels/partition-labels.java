class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();

        int i=0, j=1;
        while(j<=n){
            if(valid(s, i, j, n)){
                res.add(j-i);
                i = j;
            }
            j++;
        }

        return res;
    }

    private boolean valid(String s, int i, int j, int n){
        boolean[] fpa = new boolean[26];
        boolean[] fpb = new boolean[26];

        // String spa = s.subString(i, j);
        // String spb = s.subString(j, n);

        // for(char ch : spa.toCharArray()) fpa[ch-'a'] = true;
        // for(char ch : spb.toCharArray()) fpb[ch-'a'] = true;

        for(int idx = i; idx<j; idx++){
            char ch = s.charAt(idx);
            fpa[ch-'a'] = true;
        }

        for(int idx = j; idx<n; idx++){
            char ch = s.charAt(idx);
            fpb[ch-'a'] = true;
        }

        for(int idx=0; idx<26; idx++){
            if(fpa[idx] && fpb[idx]) return false;
        }

        return true;
    }
}


// characters at each partition DOES NOT appear in any other partition
// form partition using (i, j) and add valid to answer
// next partition start from i