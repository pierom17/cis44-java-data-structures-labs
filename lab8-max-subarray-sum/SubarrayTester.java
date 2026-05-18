import java.util.Random;

public class SubarrayTester {

    public static void main(String[] args) {
        int[] sizes = { 1000, 5000, 10000, 50000, 100000 };

        System.out.println("Lab 9: Maximum Subarray Sum Algorithm Comparison");

        for (int n : sizes) {
            System.out.println("");
            System.out.println("Testing for array size n = " + n);

            // TODO: Generate a random array and time both algorithms.
            int[] arr = generateRandomArrayWithNegatives(n);

            long start = System.nanoTime();
            int bruteForceResult = MaxSubarraySolver.bruteForceMaxSum(arr);
            long end = System.nanoTime();
            long bruteForceTime = end - start;

            start = System.nanoTime();
            int kadaneResult = MaxSubarraySolver.kadanesAlgorithmMaxSum(arr);
            end = System.nanoTime();
            long kadaneTime = end - start;

            System.out.println("Brute Force Result: " + bruteForceResult);
            System.out.println("Brute Force Time: " + bruteForceTime + " ns");

            System.out.println("Kadane Result: " + kadaneResult);
            System.out.println("Kadane Time: " + kadaneTime + " ns");
        }
    }

    public static int[] generateRandomArrayWithNegatives(int size) {
        // Implementation provided in previous response

        Random random = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(201) - 100;
        }

        return arr;
    }
}