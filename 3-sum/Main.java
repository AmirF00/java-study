import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] testCases = {
            {-1, 0, 1, 2, -1, -4},          // [[-1, -1, 2], [-1, 0, 1]]
            {0, 1, 1},                      // []
            {0, 0, 0},                      // [[0, 0, 0]]
            {-2, 0, 1, 1, 2},               // [[-2, 0, 2], [-2, 1, 1]]
            {-4, -2, -2, -2, 0, 1, 2, 2, 3, 4}, // [[-4, 0, 4], [-4, 1, 3], [-4, 2, 2], [-2, -2, 4], [-2, 0, 2], [-2, -2, 3]]
            {-1, -1, -1, 2, 2},             // [[-1, -1, 2]]
            {3, 0, -2, -1, 1, 2},           // [[-2, -1, 3], [-2, 0, 2], [-1, 0, 1]]
            {-1, 0, 1, 0},                  // [[-1, 0, 1], [0, 0, 0]]
            {},                             // []
            {0, 0},                         // []
            {-2, 0, 0, 2, 2},               // [[-2, 0, 2]]
            {-1, 4, 2, -5, 0, -4, -2, -3, 2, 0, -2, -4, -1, -2, -5, -4}, // Multiple triplets
            {1, 2, -2, -1},                 // []
            {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}, // Multiple triplets
            {0, 0, 0, 0},                   // [[0, 0, 0]]
            {-2, -1, -1, 0, 1, 1, 2, 2},    // [[-2, 0, 2], [-2, 1, 1], [-1, -1, 2], [-1, 0, 1]]
            {-4, -2, -2, -2, -1, -1, 0, 1, 2, 3, 4}, // Multiple triplets
            {-1, -1, -1, 0, 1, 1, 1},       // [[-1, 0, 1]]
            {1, -1, -1, 0},                 // [[-1, 0, 1]]
            {1, 2, -2, -1, -4},             // [[-4, 2, 2]]
            {-1, 0, 1, 2, -1, -4, -2, -1, 1, -1, -4, -2, -3, 3, 0, 4}, // Multiple triplets
        };

        for (int[] nums : testCases) {
            List<List<Integer>> result = solution.threeSum(nums);
            System.out.println("Input: " + Arrays.toString(nums));
            System.out.println("Triplets: " + result);
            System.out.println("----------");
        }
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);  // Sort the array to make it easier to avoid duplicates
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int target = -nums[i];  // The two numbers need to sum up to -nums[i]
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    // Found a triplet
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate values for left and right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    // Move pointers after finding a valid triplet
                    left++;
                    right--;
                } else if (sum < target) {
                    // Need a larger sum
                    left++;
                } else {
                    // Need a smaller sum
                    right--;
                }
            }
        }
        return res;
    }
}

