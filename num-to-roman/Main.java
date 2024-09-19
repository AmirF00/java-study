public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] testNumbers = {3, 4, 9, 58, 1994};

        for (int num : testNumbers) {
            String romanNumeral = solution.intToRoman(num);
            System.out.println("Integer: " + num + " -> Roman Numeral: " + romanNumeral);
        }
    }
}

class Solution {
    public String intToRoman(int num) {
        int[] values =    {1000, 900, 500, 400, 100, 90,  50, 40,  10, 9,   5, 4, 1};
        String[] symbols ={"M",  "CM","D", "CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                num -= values[i];
                result.append(symbols[i]);
            }
        }

        return result.toString();
    }
}

