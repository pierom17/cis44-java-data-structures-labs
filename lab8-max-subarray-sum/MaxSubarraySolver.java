public class MaxSubarraySolver {

    /**
     * Finds the maximum subarray sum using a brute-force approach.
     * Theoretical Complexity: O(n^2)
     */
    public static int bruteForceMaxSum(int[] arr) {
        /*
         * Primitive operation count:
         * The outer loop runs n times.
         * For each outer loop, the inner loop runs about n times.
         * Each inner loop performs constant-time work:
         * addition, comparison, and assignment.
         * Total operations are approximately n * n = n^2.
         * Therefore, this algorithm is O(n^2).
         */

        int maxSum = arr[0];

        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;
            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * Finds the maximum subarray sum using Kadane's Algorithm.
     * Theoretical Complexity: O(n)
     */
    public static int kadanesAlgorithmMaxSum(int[] arr) {
        /*
         * Kadane's Algorithm uses one loop through the array.
         * Each element is processed once.
         * For each element, only constant-time operations are performed.
         * Therefore, the total runtime grows linearly with n.
         * This makes the algorithm O(n).
         */
        int maxSum = arr[0];
        int currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}