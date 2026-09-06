class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // dp[j] stores the number of distinct subsequences matching t[0...j-1]
        int[] dp = new int[n + 1];
        
        // Base case: An empty string t can always be formed (exactly 1 way)
        dp[0] = 1;
        
        for (int i = 1; i <= m; i++) {
            // Traverse backwards to avoid overwriting values needed for the current row
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] = dp[j] + dp[j - 1];
                }
                // If characters don't match, dp[j] remains unchanged 
                // (inheriting the value from the previous character iteration)
            }
        }
        
        return dp[n];
    }
}
