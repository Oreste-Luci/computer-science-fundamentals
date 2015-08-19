
/**
 * QuickSort implementation
 *
 * @author Oreste Luci
 */
public class QuickSort {

    public static void main(String[] args) {

        QuickSort sort = new QuickSort();

        int[] array = {89, 4, 34, 67, 3, 9, 1, 0, 20, 40, -5, 2, 5, -2};

        sort.printArray("Input: ",array);

        array = sort.quickSort(array);

        sort.printArray("Output: ",array);
    }

    public int[] quickSort(int[] array) {

        if (array == null || array.length <= 1) {
            return array;
        }

        // Choosing pivot number as last element in the array
        int pivotNumber = array[array.length-1];
        int wall = -1;
        int temp;

        for (int i=0; i<array.length-1; i++) {

            if (array[i] < pivotNumber) {

                if (wall + 1 < i) {

                    temp = array[i];
                    array[i] = array[++wall];
                    array[wall] = temp;

                } else {
                    wall++;
                }
            }
        }

        // Changing wall in case whole list less than pivot number
        if (wall+1 == array.length-1){
            wall--;
        }

        // Swapping Pivot Number with wall
        array[array.length-1] = array[++wall];
        array[wall] = pivotNumber;

        // Creating left array
        int[] left = new int[wall+1];
        System.arraycopy(array,0,left,0,wall+1);

        // Creating right array
        int[] right = new int[array.length - (wall + 1)];
        System.arraycopy(array,wall+1,right,0,array.length - (wall + 1));

        // Sorting left and right arrays
        left = quickSort(left);
        right = quickSort(right);

        // Merging left and right arrays
        mergeSortedLists(left,right,array);

        return array;
    }

    private void mergeSortedLists(int[] list1, int[] list2, int[] result) {

        int idx1 = 0;
        int idx2 = 0;
        int idxR = 0;

        // Do until one of the lists runs out
        // Copy smaller value into result
        while (idx1 < list1.length && idx2 < list2.length) {

            if (list1[idx1] < list2[idx2]) {
                result[idxR++] = list1[idx1++];
            } else if (list1[idx1] > list2[idx2]) {
                result[idxR++] = list2[idx2++];
            } else {
                result[idxR++] = list1[idx1++];
                result[idxR++] = list2[idx2++];
            }
        }

        // If any list has remaining items copy it to result
        if (idx1 < list1.length) {
            System.arraycopy(list1,idx1,result,idxR,list1.length-idx1);
        } else if (idx2 < list2.length) {
            System.arraycopy(list2,idx2,result,idxR,list2.length-idx2);
        }
    }

    public void printArray(String msg, int[] array) {

        if (msg == null) {
            msg = "";
        }

        System.out.print(msg);

        for (int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println(" ");
    }
}
