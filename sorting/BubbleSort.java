
public class BubbleSort {

    public static void main(String[] args) {

        int[] array = {89, 4, 34, 67, 3, 9, 1, 0, 20, 40, -5, 2, 5, -2};

        bubbleSort(array);

        for (int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void bubbleSort(int[] array) {

        if (array == null || array.length <= 1) {
            return;
        }

        boolean swapped = true;

        while (swapped) {

            swapped = false;

            for (int i=0; i<array.length; i++) {
                for (int j=i+1; j<array.length; j++) {
                    if (array[i] > array[j]) {
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                        swapped = true;
                    }
                }
            }
        }
    }
}
