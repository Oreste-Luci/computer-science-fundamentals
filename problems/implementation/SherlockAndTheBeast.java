import java.util.Scanner;

/*
    Problem Statement

    Sherlock Holmes is getting paranoid about Professor Moriarty, his arch-enemy. All his efforts to subdue Moriarty have been in vain. These days Sherlock is working on a problem with Dr. Watson. Watson mentioned that the CIA has been facing weird problems with their supercomputer, 'The Beast', recently.

    This afternoon, Sherlock received a note from Moriarty, saying that he has infected 'The Beast' with a virus. Moreover, the note had the number N printed on it. After doing some calculations, Sherlock figured out that the key to remove the virus is the largest Decent Number having N digits.

    A Decent Number has the following properties:

    3, 5, or both as its digits. No other digit is allowed.
    Number of times 3 appears is divisible by 5.
    Number of times 5 appears is divisible by 3.
    Meanwhile, the counter to the destruction of 'The Beast' is running very fast. Can you save 'The Beast', and find the key before Sherlock?

    Input Format
    The 1st line will contain an integer T, the number of test cases. This is followed by T lines, each containing an integer N. i.e. the number of digits in the number.

    Output Format
    Largest Decent Number having N digits. If no such number exists, tell Sherlock that he is wrong and print −1.

    Constraints
    1≤T≤20
    1≤N≤100000


    Sample Input

    4
    1
    3
    5
    11
    Sample Output

    -1
    555
    33333
    55555533333
    Explanation
    For N=1, there is no such number.
    For N=3, 555 is the only possible number.
    For N=5, 33333 is the only possible number.
    For N=11, 55555533333 and all permutations of these digits are valid numbers; among them, the given number is the largest one.

    @author Oreste Luci
*/

public class SherlockAndTheBeast {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        int[] digits = new int[testCases];

        for (int i=0; i<testCases; i++) {
            digits[i] = scanner.nextInt();
        }

        printDecentNumbers(digits);
    }

    public static void printDecentNumbers(int[] digits) {

        for (int i=0; i<digits.length; i++) {
            try {
                System.out.println(findDecentNumber(digits[i]));
            } catch (Exception e) {
                System.out.println(-1);
            }
        }
    }

    public static String findDecentNumber(int digits) {

        StringBuffer output = new StringBuffer();

        while (true) {

            if (digits < 3) {
                return "-1";
            }

            if (digits == 3) {
                output.append("555");
                break;
            }

            if (digits == 5) {
                output.append("33333");
                break;
            }

            if (digits == 10) {
                output.append("3333333333");
                break;
            }

            if (digits % 5 == 0 && digits % 3 == 0) {
                for (int i=0; i<digits; i++) {
                    output.append("5");
                }
                break;
            }

            output.append("555");

            digits = digits - 3;

        }

        return output.toString();
    }
}
