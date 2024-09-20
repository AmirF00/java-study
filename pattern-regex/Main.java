public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[][] testCases = {
            {"aa", "a"},            // false
            {"aa", "a*"},           // true
            {"ab", ".*"},           // true
            {"aab", "c*a*b"},       // true
            {"mississippi", "mis*is*p*."}, // false
            {"", ""},               // true
            {"", ".*"},             // true
            {"", "a*"},             // true
            {"ab", ".*c"},          // false
            {"aaa", "a*a"},         // true
            {"aaa", "ab*a*c*a"},    // true
            {"abcd", "d*"},         // false
            {"a", "ab*"},           // true
            {"a", ".*..a*"},        // false
            {"bbbba", ".*a*a"},     // true
            {"ab", "a.*b"},         // true
            {"abc", "abc.*"},       // true
            {"aaa", "aaaa"},        // false
            {"aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s"}, // true
            {"a", "ab*"},           // true
            {"abcd", ".*d"},        // true
            {"ab", ".*.."},         // true
            {"", "c*"},             // true
            {"", ".*c"},            // false
            {"c", "."},             // true
            {"aabcbcbcaccbcaabc", ".*a*aa*.*b*.c*.*a*"}, // true
            {"aaa", "ab*a*c*a"},    // true
            {"aaa", "ab*ac*a"},     // true
            {"aab", "c*a*b"},       // true
            {"abcd", "abcde*"},     // false
        };

        for (String[] testCase : testCases) {
            String s = testCase[0];
            String p = testCase[1];
            boolean result = solution.isMatch(s, p);
            System.out.println("Input: s = \"" + s + "\", p = \"" + p + "\" => Output: " + result);
        }
    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int m = s.length();
        int n = p.length();

        // dp[i][j] will be true if s[0..i) matches p[0..j)
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty string matches empty pattern
        dp[0][0] = true;

        // Initialize dp for patterns like a*, a*b*, a*b*c*
        for (int j = 2; j <= n; j += 2) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }

        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            char sc = s.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1);

                if (pc == '*') {
                    // Zero occurrence of the character before '*'
                    dp[i][j] = dp[i][j - 2];

                    char pPrev = p.charAt(j - 2);
                    if (pPrev == '.' || pPrev == sc) {
                        // One or more occurrences
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else if (pc == '.' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}

