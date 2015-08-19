import java.io.Console;

/**
 * Returns the Nth Fibonacci Number
 * @author Oreste Luci
 */
public class FibonacciNthNumber {

    public static void main(String[] args) {

        FibonacciNthNumber fib = new FibonacciNthNumber();

        Console console = System.console();

        System.out.println("Enter the position for which you want the fib number: ");

        String position = console.readLine();

        int fibNumber = fib.fibPosition(Integer.parseInt(position));

        System.out.println("The fib number is: " + fibNumber);
    }

    public int fibPosition(int number) {

        if (number == 0) {
            return 0;
        }

        if (number == 1) {
            return 1;
        }

        return fibPosition(number-1) + fibPosition(number-2);
    }
}
