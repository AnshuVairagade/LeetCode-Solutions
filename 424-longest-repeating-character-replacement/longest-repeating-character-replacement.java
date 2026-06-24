class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int maxLen = 0;
        int freq[] = new int[26];

        int low = 0, high = 0;
        while(high < n){

            freq[s.charAt(high)-'A']++;

            // Bug: Runtime Shrinking of window need recomputation of windowLength & maxFrequency.

            while((high - low + 1) - getMaxFrequency(freq) > k){
                freq[s.charAt(low)-'A']--;
                low++;
            }

            maxLen = Math.max(maxLen, (high - low + 1));
            high++;
        }

        return maxLen;
    }

    private int getMaxFrequency(int freq[]){
        int maxFreq = 0;

        for(int cnt : freq) maxFreq = Math.max(maxFreq, cnt);

        return maxFreq;
    }
}

/*

I failed to solve, because I don't understand how to check valid window

Core Logic to calculate valid substring :

    maxFreq = Math.max(maxFreq, freq[s.charAt(i)-'A']);

    replacementNeeded = windowLength - maxFreq

    if(replacementNeeded <= k){
        maxLen = Math.max(windowLength, maxLen);
    }

    same logic is implemented in Sliding window optimization:
    
    Expand window & calculate answer



Brute Force:

class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int maxLen = 0;
        for(int i=0; i<n; i++){
            
            int freq[] = new int[26];
            int maxFreq = 0;

            for(int j=i; j<n; j++){
                freq[s.charAt(j)-'A']++;
                
                maxFreq = Math.max(maxFreq, freq[s.charAt(i)-'A']);

                int windowLength = j-i+1;
                int replacementNeeded = windowLength - maxFreq;

                if(replacementNeeded <= k){
                    maxLen = Math.max(windowLength, maxLen);
                }
            }
        }

        return maxLen;
    }
}


*/