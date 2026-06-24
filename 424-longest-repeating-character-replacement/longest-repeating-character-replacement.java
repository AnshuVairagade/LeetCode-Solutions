class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        /*
            Common Bug Point in Sliding Window Problems:
                
                1) Dynamic window size changes after shrinking
                    - Whenever sliding window uses information derived from window
                      like maxFreq, distinctCount, maximumElement
                      
                    - Recompute it after shrinking
                    - Use a data structure that updates correctly
 
                2) Addition and Subtraction of element -> frequency

                3) High and Low pointer movement

                4) Wrong answer calculations.

                5) Invalid Window Condition Bug
        */


        int maxLen = 0;
        int maxFreq = 0;
        int freq[] = new int[26];

        int low = 0, high = 0;
        while(high < n){
            freq[s.charAt(high)-'A']++;

            maxFreq = Math.max(maxFreq, freq[s.charAt(high)-'A']);

            // Logic: Maximum valid window length maintained

            if((high - low + 1) - maxFreq > k){
                freq[s.charAt(low)-'A']--;
                low++;
            }

            maxLen = Math.max(maxLen, (high - low + 1));
            high++;
        }

        return maxLen;
    }

}

/*

Using the monotonicity of normal sliding window, once valid window is formed try to maintain it.
Try to find out next winddow with maxFreq increasing.


Question:

While shrinking the window, the frequency of the character contributing to maxFreq may decrease or even leave the window entirely. Since the optimized solution never recomputes or decreases maxFreq, how can the algorithm still produce the correct answer?

1. Why don't we recalculate maxFreq after shrinking?

2. Doesn't the stored maxFreq become incorrect for the current window?

3. How can an outdated (historical) maxFreq still be sufficient to decide when to shrink the window?

4. Why doesn't using a stale maxFreq cause us to miss the correct answer or overestimate the maximum valid window length?

5. What is the intuition behind storing the historical maximum frequency instead of the current window's maximum frequency?



*/