// Approach 1 : Loop through to calculate total rows to arrange coins
// Approach 2 : Use Binary search with formula of sum to find max that can be arranged.
// Approach 3 : Solve the inequality to get the formula.


class Solution {
    public int arrangeCoins(int n) {
        return (int)((Math.sqrt(1 + 8L * (long)n) - 1) / 2);
    }
}