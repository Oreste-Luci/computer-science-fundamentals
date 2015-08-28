/**
 * Binary Search in Array
 * @author Oreste Luci
 */
public class BinarySearch {

    public static void main(String[] args) {

        BinarySearch bs = new BinarySearch();

        int[] array = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        bs.printArray(array);

        int number = 20;
        System.out.println("Number " + number + " is in position " + bs.binarySearch(number,array,0,array.length));

        number = 80;
        System.out.println("Number " + number + " is in position " + bs.binarySearch(number,array,0,array.length-1));

        number = 10;
        System.out.println("Number " + number + " is in position " + bs.binarySearch(number,array,0,array.length));

        number = 100;
        System.out.println("Number " + number + " is in position " + bs.binarySearch(number,array,0,array.length));

        number = 50;
        System.out.println("Number " + number + " is in position " + bs.binarySearch(number,array,0,array.length));
    }

    public int binarySearch(int number, int[] array, int begin, int end) {

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
            return binarySearch(number, array, begin, mid);
        } else {
            return binarySearch(number, array, mid, end);
        }
    }

    private void printArray(int[] array) {

        for (int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(" ");
    }
}
