import java.io.Console;

/**
 * Determines if a number X is 2^n
 *
 * @author Oreste Luci
 */
public class IsNumberPowerOfTwo {

    public static void main(String[] args) {

        Console console = System.console();

        System.out.println("Enter number: ");
        int number = Integer.parseInt(console.readLine());

        System.out.println("Number is power of 2: " + isPowerOfTwo(number));
    }

    /**
     * The method uses the following property;
     * 2^n & (2^n - 1) = 0
     */
    public static boolean isPowerOfTwo(int number) {

        int oneLess = number - 1;

        int result = number & oneLess;

        if (result == 0) {
            return true;
        } else {
            return false;
        }
    }
}
