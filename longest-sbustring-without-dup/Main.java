public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test examples
        String[] testInputs = {
            "abcabcbb",
            "bbbbb",
            "pwwkew",
            "",
            "dvdf",
            "anviaj",
            "abba",
            " ",
            "au",
            "aabaab!bb",
            "tmmzuxt"
        };

        for (String input : testInputs) {
            int length = solution.lengthOfLongestSubstring(input);
            System.out.println("Input: \"" + input + "\"");
            System.out.println("Length of longest substring without repeating characters: " + length);
            System.out.println("--------------------------------------------");
        }
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int result = 0;
        int[] index = new int[128]; // Assuming ASCII characters

        for (int left = 0, right = 0; right < n; right++) {
            char currentChar = s.charAt(right);

            // Update left pointer
            left = Math.max(index[currentChar], left);

            // Update result if we found a longer substring
            result = Math.max(result, right - left + 1);

            // Store the index of the next character
            index[currentChar] = right + 1;
        }

        return result;
    }
}

