import java.io.Console;

/**
 * Gives the position in the Fibonacci series of the given N number.
 *
 * @author Oreste Luci
 */
public class FibonacciPositionNumber {

    public static void main(String[] args) {

        FibonacciPositionNumber fib = new FibonacciPositionNumber();

        Console console = System.console();

        System.out.println("Enter a number in the Fibonacci series: ");
        String number = console.readLine();

        int position = fib.fibNumberIter(Integer.parseInt(number));
        System.out.println("\nThe position of the number is (iterative): " + position);

        position = fib.fibNumberRecursive(Integer.parseInt(number));
        System.out.println("The position of the number is (recursive): " + position);
    }

    public int fibNumberIter(int number) {

        if (number == 0) {
            return 0;
        }

        if (number == 1) {
            return 1;
        }

        int number1 = 0;
        int number2 = 1;
        int position = 1;
        int sum;

        System.out.print("0 1 ");

        while (true) {

            sum = number1 + number2;
            position++;

            System.out.print(sum + " ");

            if (sum == number) {
                return position;
            } else {

                if (sum > number) {
                    throw new RuntimeException("Given number not in Fibonacci Series.");
                }

                number1 = number2;
                number2 = sum;
            }
        }
    }

    private int fibNumberRecursive(int number) {

        if (number == 0) {
            return 0;
        }

        if (number == 1) {
            return 1;
        }

        return fibNumberRecursive2(number,2,1,1);
    }

    private int fibNumberRecursive2(int number, int position, int number1, int number2) {

        int sum = number1 + number2;
        position++;

        if (sum == number) {
            return position;
        }

        if (sum > number) {
            throw new RuntimeException("Given number not in Fibonacci Series.");
        }

        return fibNumberRecursive2(number,position,number2,sum);
    }
}
