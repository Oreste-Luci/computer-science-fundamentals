import java.util.Arrays;
/**
 * Determines if the array contains two numbers that sum the given number.
 */
public class TargetSum {


	public static void main(String[] args) {

		int[] data1 = {30,20,2,5,-1,-2,0}; 
		System.out.println("1. " + hasPairThatSums(25,data1));

		int[] data2 = {1,-1,0}; 
		System.out.println("2. " + hasPairThatSums(0,data2));

		int[] data3 = {}; 
		System.out.println("2. " + hasPairThatSums(7,data3));

		int[] data4 = {1}; 
		System.out.println("2. " + hasPairThatSums(1,data4));

		int[] data5 = {9,8,7,6,5,4,3,2,1}; 
		System.out.println("2. " + hasPairThatSums(100,data5));

		int[] data6 = {-100,-50,-10,0,1,40,50,80,90}; 
		System.out.println("2. " + hasPairThatSums(0,data6));
	}

	/**
	 * Steps:
	 * 1. Sorts the array
	 * 2. Advances from edges until it finds the sum.
	 */
	public static boolean hasPairThatSums(int number, int[] array) {

		if (array == null || array.length <= 1 ) {
			return false;
		}

		sort(array);

		int leftIndex = 0;
		int rightIndex = array.length - 1;

		while (leftIndex != rightIndex) {

			int valueLeft = array[leftIndex];
			int valueRight = array[rightIndex];

			int sum = valueLeft + valueRight;

			if (sum == number) {
				return true;
			} else if (sum > number) {
				rightIndex--;
			} else {
				leftIndex++;
			}
		}

		return false;
	}

	private static void sort(int[] array) {
		Arrays.sort(array);
	}
}