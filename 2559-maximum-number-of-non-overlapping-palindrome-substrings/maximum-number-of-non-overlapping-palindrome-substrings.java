class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            // Carry over the maximum number of palindromes from the previous position
            dp[i] = Math.max(dp[i], dp[i - 1]);
            
            // 1. Check for odd-length palindromes centered at i - 1
            int l = i - 1, r = i - 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 >= k) {
                    dp[r + 1] = Math.max(dp[r + 1], dp[l] + 1);
                    break; // Greedily stop at the shortest valid palindrome
                }
                l--;
                r++;
            }
            
            // 2. Check for even-length palindromes centered between i - 1 and i
            l = i - 1; 
            r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 >= k) {
                    dp[r + 1] = Math.max(dp[r + 1], dp[l] + 1);
                    break; // Greedily stop at the shortest valid palindrome
                }
                l--;
                r++;
            }
        }
        
        return dp[n];
    }
}
