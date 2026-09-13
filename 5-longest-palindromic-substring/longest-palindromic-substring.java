class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        // Transform: add boundaries (#) to handle even length palindromes
        StringBuilder t = new StringBuilder("^");
        for (char c : s.toCharArray()) {
            t.append("#").append(c);
        }
        t.append("#$");

        int n = t.length();
        int[] P = new int[n];
        int center = 0, right = 0;

        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i;

            if (i < right)
                P[i] = Math.min(right - i, P[mirror]);

            // Attempt to expand palindrome centered at i
            while (t.charAt(i + (1 + P[i])) == t.charAt(i - (1 + P[i]))) {
                P[i]++;
            }

            // Update center and right boundary if expanded palindrome is beyond right
            if (i + P[i] > right) {
                center = i;
                right = i + P[i];
            }
        }

        // Find the maximum palindrome
        int maxLen = 0, centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        Solution lpo = new Solution();
        System.out.println(lpo.longestPalindrome("babad")); // Output: bab or aba
        System.out.println(lpo.longestPalindrome("cbbd"));  // Output: bb
    }
}
