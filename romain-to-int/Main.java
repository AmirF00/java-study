public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] testCases = {
            "III",          // 3
            "IV",           // 4
            "IX",           // 9
            "LVIII",        // 58
            "MCMXCIV",      // 1994
            "MMMCMXCIX",    // 3999
            "XLII",         // 42
            "LXXXIX",       // 89
            "CDXLIV",       // 444
            "MMMDCCCLXXXVIII", // 3888
            "MDCCLXXVI",    // 1776
            "MMXXIII",      // 2023
            "DCCCXC",       // 890
            "CMXCIX",       // 999
            "XCIX",         // 99
            "XLIX",         // 49
            "MCDXLIV",      // 1444
            "MDCLXVI",      // 1666
            "CMXCIV",       // 994
            "CDXCIX",       // 499
            "MMMM",         // 4000 (non-standard but sometimes used)
            "MMMIM"         // 3999 (using subtractive notation beyond standard)
        };

        for (String roman : testCases) {
            try {
                int result = solution.romanToInt(roman);
                System.out.println("Roman numeral: " + roman + " => Integer: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("Roman numeral: " + roman + " => " + e.getMessage());
            }
        }
    }
}

class Solution {
    public int romanToInt(String s) {
        int total = 0;
        int prevValue = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int currValue = value(s.charAt(i));
            if (currValue < prevValue) {
                total -= currValue;
            } else {
                total += currValue;
            }
            prevValue = currValue;
        }
        return total;
    }

    private int value(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default:
                throw new IllegalArgumentException("Invalid Roman numeral character: " + c);
        }
    }
}

