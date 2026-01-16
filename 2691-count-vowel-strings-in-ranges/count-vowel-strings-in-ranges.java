class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int psum[] = new int[words.length];

        psum[0] = isValid(words[0]) ? 1 : 0;
        for(int i=1; i<words.length; i++){
            if(isValid(words[i])){
                psum[i] = 1;
            }
            psum[i] += psum[i-1];
        }

        int res[] = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int st = queries[i][0];
            int end = queries[i][1];

            res[i] = psum[end] - ((st > 0) ? psum[st-1] : 0);
        }

        return res;
    }

    private boolean isValid(String word){
        String vowel = "aeiouAEIOU";
        char start = word.charAt(0);
        char end = word.charAt(word.length()-1);
        return (vowel.indexOf(start)!= -1 && vowel.indexOf(end)!= -1);
    }
}


/* Question: Find the strings starting and ending with vowel in words array that lie in range [l, r]



# Brute Force: 
For eah query iterate words in the range of index and count valid string
TC = O(queries * n)    where n = words.length

# Optimal Solution :
Use prefix sum to calculate valid string in the perticular range
TC = (queries + n)
SC = (n)

*/