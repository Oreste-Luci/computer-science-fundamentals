import java.util.Scanner;

/*
    Problem Statement

    The Head Librarian at a library wants you to make a program that calculates the fine for returning the book after the return date. You are given the actual and the expected return dates. Calculate the fine as follows:

    If the book is returned on or before the expected return date, no fine will be charged, in other words fine is 0.
    If the book is returned in the same month as the expected return date, Fine = 15 Hackos × Number of late days
    If the book is not returned in the same month but in the same year as the expected return date, Fine = 500 Hackos × Number of late months
    If the book is not returned in the same year, the fine is fixed at 10000 Hackos.

    Input Format

    You are given the actual and the expected return dates in D M Y format respectively. There are two lines of input. The first line contains the D M Y values for the actual return date and the next line contains the D M Y values for the expected return date.

    Constraints
    1≤D≤31
    1≤M≤12
    1≤Y≤3000
    Output Format

    Output a single value equal to the fine.

    Sample Input

    9 6 2015
    6 6 2015

    Sample Output

    45

    Explanation

    Since the actual date is 3 days later than expected, fine is calculated as 15×3=45 Hackos.
*/
public class LibraryFine {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int d2 = scanner.nextInt();
        int m2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        int d1 = scanner.nextInt();
        int m1 = scanner.nextInt();
        int y1 = scanner.nextInt();

        System.out.println(calculateFine(d1, m1, y1, d2, m2, y2));
    }

    public static int calculateFine(int d1, int m1, int y1, int d2, int m2, int y2) {

        if (d1>=d2 && m1>=m2 && y1>=y2) {
            return 0;
        }

        if (y1>y2) {
            return 0;
        }

        if (m1>m2 && y1>=y2) {
            return 0;
        }

        if (d1<d2 && m1>=m2 && y1>=y2) {
            int diff = d2 - d1;
            return diff * 15;
        }

        if (m1<m2 && y1>=y2) {
            int diff = m2 - m1;
            return diff * 500;
        }

        if (y1<y2) {
            return 10000;
        }

        return 0;
    }
}
