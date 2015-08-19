
/**
 * Merge Sort
 */
public class MergeSort {

    public static void main(String[] args) {

        MergeSort sort = new MergeSort();

        int[] array = {89, 4, 34, 67, 3, 9, 1, 0, 20, 40, -5, 2, 5, -2};

        array = sort.mergeSort(array);

        for (int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println(" ");
    }

    /**
     * Recursive method that splits the input array and merges the results.
     */
    public int[] mergeSort(int[] array) {

        if (array.length <= 1) {
            return array;
        }

        int pivot = array.length/2 - 1;

        int leftSize = pivot + 1;
        int rightSize = array.length - (pivot  + 1);

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        System.arraycopy(array,0,left,0,leftSize);
        System.arraycopy(array,leftSize,right,0,rightSize);

        mergeSort(left);
        mergeSort(right);

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
}
