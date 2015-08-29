/**
 * Binary Search in Array
 * @author Oreste Luci
 */
public class BinarySearch {

    public static void main(String[] args) {

        BinarySearch bs = new BinarySearch();

        int[] array = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        bs.printArray(array);

        int[] findNumbers = {20, 80, 10, 100, 50};

        for (int number : findNumbers) {
            System.out.println(" ");
            System.out.println("R: Number " + number + " is in position " + bs.binarySearchR(number,array,0,array.length));
            System.out.println("I: Number " + number + " is in position " + bs.binarySearchI(number,array));
        }

        int[] array2 = {10, 20, 20, 20, 30, 40, 50, 60, 70, 80, 90, 90, 90, 100};
        System.out.println(" ");
        bs.printArray(array2);

        int number = 20;
        System.out.println(" ");
        System.out.println("Lowest ocurrence of " + number + " is in position " + bs.binarySearchLHOcurrance(number,array,true));
        System.out.println("Highest ocurrence of " + number + " is in position " + bs.binarySearchLHOcurrance(number,array,false));

        number = 40;
        System.out.println(" ");
        System.out.println("Lowest ocurrence of " + number + " is in position " + bs.binarySearchLHOcurrance(number,array,true));
    }

    public int binarySearchR(int number, int[] array, int begin, int end) {

        if (array == null || array.length == 0) {
            throw new RuntimeException("array is empty");
        }

        if (end < begin || begin == end) {
            throw new RuntimeException("Number not in array");
        }

        int mid = begin + (end - begin) / 2;

        if (number == array[mid]) {
            return mid;
        } else if (number < array[mid]) {
            return binarySearchR(number, array, begin, mid);
        } else {
            return binarySearchR(number, array, mid, end);
        }
    }

    public int binarySearchI(int number, int[] array) {

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {

            int mid = (high + low) / 2;

            if (array[mid] == number) {
                return mid;
            } else if (number < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public int binarySearchLHOcurrance(int number, int[] array, boolean lowest) {

        int low = 0;
        int result = -1;
        int high = array.length;
        int mid;

        while (low <= high) {

            mid = (high + low) / 2;

            if (array[mid] == number) {

                result = mid;

                if (lowest) { // Lowest Ocurrence
                    high = mid - 1;
                } else { // Highest Ocurrance
                    low = mid + 1;
                }

            } else if (number < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    private void printArray(int[] array) {

        for (int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(" ");
    }
}
