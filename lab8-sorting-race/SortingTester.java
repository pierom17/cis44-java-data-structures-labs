import java.util.Arrays;
import java.util.Random;

public class SortingTester {

    public static void main(String[] args) {
        int[] sizes = { 1000, 5000, 10000, 25000, 50000, 100000 };

        System.out.println("Lab 8 Sorting");
        for (int n : sizes) {
            System.out.println("");
            System.out.println("Testing for array size n = " + n);

            // TODO: Call your test methods for Average, Best, and Worst cases.

            runAndTimeAllSorts("Average Case", generateRandomArray(n));
            runAndTimeAllSorts("Best Case", generateSortedArray(n));
            runAndTimeAllSorts("Worst Case", generateReverseSortedArray(n));
        }
    }

    // TODO: Implement the runAndTimAllSorts helper method.

    public static void runAndTimeAllSorts(String caseName, int[] original) {
        System.out.println("\n" + caseName + ":");

        int[] selectionArray = Arrays.copyOf(original, original.length);
        long start = System.nanoTime();
        SortingAlgorithms.selectionSort(selectionArray);
        long end = System.nanoTime();
        System.out.println("Selection Sort: " + (end - start) + " ns");

        int[] insertionArray = Arrays.copyOf(original, original.length);
        start = System.nanoTime();
        SortingAlgorithms.insertionSort(insertionArray);
        end = System.nanoTime();
        System.out.println("Insertion Sort: " + (end - start) + " ns");

        int[] mergeArray = Arrays.copyOf(original, original.length);
        start = System.nanoTime();
        SortingAlgorithms.mergeSort(mergeArray);
        end = System.nanoTime();
        System.out.println("Merge Sort: " + (end - start) + " ns");
    }

    public static int[] generateRandomArray(int size) {
        // Implementation provided in previous response
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size * 10);
        }
        return arr;
    }

    public static int[] generateSortedArray(int size) {
        // Implementation provided in previous response

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static int[] generateReverseSortedArray(int size) {
        // Implementation provided in previous response

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }
}