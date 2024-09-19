public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[][] testCases = {
            {"flower", "flow", "flight"},         // "fl"
            {"dog", "racecar", "car"},            // ""
            {"interview", "integrate", "integral"}, // "inte"
            {"", "b", "c"},                       // ""
            {"a"},                                 // "a"
            {"reflower", "flow", "flight"},       // ""
            {"interspecies", "interstellar", "interstate"}, // "inters"
            {"throne", "throne"},                 // "throne"
            {"throne", "dungeon"},                // ""
            {"prefix", "prefixes", "prefixation"}, // "prefix"
            {"", "", ""},                          // ""
            {"commonprefix", "commonprefix"},      // "commonprefix"
            {"longest", "longer", "long"},         // "long"
            {"abc", "abcd", "ab"},                 // "ab"
            {"same", "same", "same"},              // "same"
            {"apple", "app"},                      // "app"
            {"", "a"},                             // ""
            {"a", "a", "a"},                       // "a"
            {"abcdef", "abc"},                     // "abc"
            {"xyz", "xy", "x"},                    // "x"
            {"abcdefg", "abcxyz", "abc123"},       // "abc"
            {"prefixsuffix", "prefix", "pre"},     // "pre"
        };

        for (String[] strs : testCases) {
            String result = solution.longestCommonPrefix(strs);
            System.out.println("Input: " + String.join(", ", strs) + " => Longest Common Prefix: \"" + result + "\"");
        }
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        // Start with the first string as the prefix
        String prefix = strs[0];
        
        // Compare the prefix with each string in the array
        for (int i = 1; i < strs.length; i++) {
            // Reduce the prefix length until it matches the beginning of strs[i]
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}

