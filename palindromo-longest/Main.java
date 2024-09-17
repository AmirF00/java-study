public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] testCases = {
            "babad",
            "cbbd",
            "a",
            "ac",
            "abacdfgdcaba",
            "forgeeksskeegfor",
            "",
            "aaaaa",
            "abcba"
        };

        for (String testCase : testCases) {
            String result = solution.longestPalindrome(testCase);
            System.out.println("Input: \"" + testCase + "\"");
            System.out.println("Longest Palindromic Substring: \"" + result + "\"");
            System.out.println();
        }
    }
}

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String T = preprocessString(s);
        int n = T.length();
        int[] P = new int[n];
        int C = 0, R = 0; // Center and right boundary
        for (int i = 1; i < n - 1; i++) {
            int i_mirror = 2 * C - i; // Mirror of i around center C

            // Initialize P[i] based on its mirror or the boundary
            if (R > i) {
                P[i] = Math.min(R - i, P[i_mirror]);
            } else {
                P[i] = 0;
            }

            // Expand palindrome centered at i
            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            // Update center and right boundary if expanded past R
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
        }

        // Find the maximum element in P
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }

        // Extract the longest palindrome from the original string
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }

    private String preprocessString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('^'); // Start sentinel
        for (int i = 0; i < s.length(); i++) {
            sb.append('#');
            sb.append(s.charAt(i));
        }
        sb.append("#$"); // End sentinel
        return sb.toString();
    }
}

