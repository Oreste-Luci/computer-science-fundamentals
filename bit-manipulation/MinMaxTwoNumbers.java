import java.io.Console;

/**
 * Determining min and max of two numbers
 *
 * @author Oreste Luci
 */

public class MinMaxTwoNumbers {

    public static void main(String[] args) {

        Console console = System.console();

        System.out.println("Enter number one:");
        int number1 = Integer.parseInt(console.readLine());

        System.out.println("Enter number two:");
        int number2 = Integer.parseInt(console.readLine());

        System.out.println("The minimun is: " + minimum(number1,number2));
        System.out.println("The maximum is: " + maximum(number1,number2));
    }

    /**
     * min(x,y) = y ^ ((x ^ y) & -(x < y))
     */
    public static int minimum(int x, int y) {

        int min = y ^ comparisonOperation(x,y);

        return min;
    }

    /**
     * max(x,y) = x ^ ((x ^ y) & - (x < y))
     */
    public static int maximum(int x, int y) {

        int max = x ^ comparisonOperation(x,y);

        return max;
    }

    private static int comparisonOperation(int x, int y) {

        int result = ((x ^ y) & -(x < y?1:0));

        return result;
    }
}
