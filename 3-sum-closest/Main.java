import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] testCasesNums = {
            {-1, 2, 1, -4},            // Expected output: 2
            {0, 0, 0},                 // Expected output: 0
            {1, 1, 1, 0},              // Expected output: 2
            {1, 2, 5, 10, 11},         // Expected output: 13
            {-1, -2, -3, -4, -5},      // Expected output: Sum closest to target
            {0, 1, 2},                 // Expected output: Sum closest to target
            {1, 1, -1, -1, 3},         // Expected output: Sum closest to target
            {-1, 0, 1, 1, 55},         // Expected output: Sum closest to target
            {-5, -4, -3, -2, -1},      // Expected output: Sum closest to target
            {0, 2, 1, -3},             // Expected output: Sum closest to target
            {4, 0, 5, -5, 3, 3, 0, -4, -5}, // Expected output: Sum closest to target
            {13, 2, 0, -14, -20, 3},   // Expected output: Sum closest to target
            {-7, -71, -71, -55, -33, -63, 0, 5, 33}, // Expected output: Sum closest to target
            {0, 1, 2, -1, -4},         // Expected output: Sum closest to target
            {1, 6, 9, 14, 16, 70},     // Expected output: Sum closest to target
            {0, 2, 1, -3},             // Expected output: Sum closest to target
            {-1, 2, 1, -4},            // Expected output: Sum closest to target
            {1, 1, 1, 0},              // Expected output: Sum closest to target
            {1, 1, -1, -1, 3},         // Expected output: Sum closest to target
            {-1, 2, 1, -4},            // Expected output: Sum closest to target
        };

        int[] testCasesTargets = {
            1,
            1,
            -100,
            13,
            -10,
            3,
            -1,
            3,
            -10,
            1,
            -2,
            -12,
            -33,
            1,
            80,
            1,
            -100,
            -1,
            1,
        };

        for (int i = 0; i < testCasesNums.length; i++) {
            int[] nums = testCasesNums[i];
            int target = testCasesTargets[i];
            int result = solution.threeSumClosest(nums, target);
            System.out.println("Input nums: " + Arrays.toString(nums) + ", target: " + target);
            System.out.println("Closest sum: " + result);
            System.out.println("----------");
        }
    }
}

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);  // Sort the array first
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[n - 1];  // Initialize with a sum

        for (int i = 0; i < n - 2; i++) {
            // Avoid duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // Update the closestSum if currentSum is closer to target
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // Move pointers based on comparison with target
                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    // Exact match found
                    return currentSum;
                }
            }
        }
        return closestSum;
    }
}

