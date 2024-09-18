public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] testCases = {
            121,           // Palindrome positive number
            -121,          // Negative number, not a palindrome
            10,            // Not a palindrome
            12321,         // Palindrome odd length
            1221,          // Palindrome even length
            1234567899,    // Large number, not a palindrome
            0,             // Zero, palindrome
            1,             // Single-digit number, palindrome
            1000021,       // Not a palindrome
            2147447412,    // Palindrome large number
            2147483647,    // Max int value, not a palindrome
            -2147447412    // Negative palindrome number, should return false
        };

        for (int x : testCases) {
            boolean result = solution.isPalindrome(x);
            System.out.println("Input: " + x);
            System.out.println("Is Palindrome: " + result);
            System.out.println();
        }
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        // Numbers ending with 0 (except 0 itself) are not palindromes
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int revertedNumber = 0;

        // Reverse half of the digits
        while (x > revertedNumber) {
            int digit = x % 10;
            revertedNumber = revertedNumber * 10 + digit;
            x /= 10;
        }

        // Check for both even and odd length numbers
        return x == revertedNumber || x == revertedNumber / 10;
    }
}

