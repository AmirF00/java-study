public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] testCases = {123, -456, 120, 1534236469, -2147483648, 0};

        for (int x : testCases) {
            int result = solution.reverse(x);
            System.out.println("Input: " + x);
            System.out.println("Reversed: " + result);
            System.out.println();
        }
    }
}

class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            
            // Check for overflow before multiplying and adding
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7))
                return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && digit < -8))
                return 0;
            
            result = result * 10 + digit;
        }
        return result;
    }
}

