public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        String[] testStrings = {
            "PAYPALISHIRING",
            "PAYPALISHIRING",
            "A",
            "",
            "ABCD",
            "HELLO",
            "THISISAZIGZAG",
            "ABCDEFGHIJKLMNOP"
        };

        int[] numRowsArray = {
            3,
            4,
            1,
            1,
            2,
            3,
            4,
            5
        };

        for (int i = 0; i < testStrings.length; i++) {
            String s = testStrings[i];
            int numRows = numRowsArray[i];
            String result = solution.convert(s, numRows);
            System.out.println("Input: s = \"" + s + "\", numRows = " + numRows);
            System.out.println("Output: \"" + result + "\"");
            System.out.println();
        }
    }
}

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        // Initialize StringBuilder for each row
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int curRow = 0;
        boolean goingDown = false;

        // Build the zigzag pattern
        for (char c : s.toCharArray()) {
            rows[curRow].append(c);
            // Change direction at the top or bottom row
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            // Move to the next row
            curRow += goingDown ? 1 : -1;
        }

        // Combine all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}

