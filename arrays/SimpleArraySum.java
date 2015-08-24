import java.util.Scanner;

/*
    Problem Statement

    You are given an array of integers of size N. You need to print the sum of the elements of the array.

    Input Format
    The first line of the input consists of an integer N. The next line contains N space-separated integers describing the array.

    Constraints
    1≤N≤1000
    0≤A[i]≤1000

    Output Format
    Output a single value equal to the sum of the elements of the array.
 */
public class SimpleArraySum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] array = new int[n];

        for (int i=0; i<n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print(sum(array));
    }

    public static int sum(int[] array) {

        int sum = 0;

        for (int i=0; i<array.length; i++) {

            sum = sum + array[i];

            if (sum < 0) {
                throw new RuntimeException("Sum too big to handle!!");
            }
        }

        return sum;
    }
}
