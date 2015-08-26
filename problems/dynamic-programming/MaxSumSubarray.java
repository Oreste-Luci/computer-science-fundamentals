/**
 * Find the maximum sum of continuous sub-array
 * @author Oreste Luci
 */
public class MaxSumSubarray {

    public static void main(String[] args) {

        System.out.println(" ");
        int[] array = {-5, 0, -4, 1, 4, 3, -2, -1, 2, -3};
        printArray(array);
        System.out.println("Max continuous sum: " + maxSubArraySum(array));

        System.out.println(" ");
        int[] array2 = {5, 10000, -1, 30000};
        printArray(array2);
        System.out.println("Max continuous sum: " + maxSubArraySum(array2));

        System.out.println(" ");
        int[] array3 = {5, 10000, -1, 30000, -40000};
        printArray(array3);
        System.out.println("Max continuous sum: " + maxSubArraySum(array3));
    }

    public static int maxSubArraySum(int[] array) {

        array[0] = Math.max(0,array[0]);

        // Adding continuous values
        for (int i=1; i<array.length; i++) {
            array[i] = Math.max(array[i-1] + array[i],0);
        }

        printArray(array);

        // Finding the highest value
        int max = 0;
        for (int i=0; i<array.length; i++) {
            max = Math.max(max, array[i]);
        }

        return max;
    }

    public static void printArray(int[] array) {
        for (int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(" ");
    }
}
