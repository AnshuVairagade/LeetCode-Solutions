// Why previous submission TLE???
// Write entire code from scratch.

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        return tabulation(nums1, nums2);
    }
    
    // Below commented code tells why not to use memoization

    private int tabulation(int nums1[], int nums2[]){
        int n = nums1.length;
        int m = nums2.length;

        int dp[][] = new int[n+1][m+1];
        int ans = 0;

        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                if(nums1[i] == nums2[j]){
                    dp[i][j] = 1 + dp[i+1][j+1];
                    ans = Math.max(ans, dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }
}

// Tabulation is variation of LCS


/*




// ================= MEMOIZATION =================

class Solution 

    private int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        Integer[][] dp = new Integer[n][m];

        int ans = 0;

        // call for every start pair so all states get filled
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, memoization(i, j, nums1, nums2, dp));
            }
        }
        return ans;
    }

    private int memoization(int i, int j, int[] nums1, int[] nums2, Integer[][] dp) {
        if (i == nums1.length || j == nums2.length) {
            return 0;
        }

        if (dp[i][j] != null) return dp[i][j];

        if (nums1[i] == nums2[j]) {
            dp[i][j] = 1 + memoization(i + 1, j + 1, nums1, nums2, dp);
        } else {
            dp[i][j] = 0;
        }

        return dp[i][j];
    }


}









*/