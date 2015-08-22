import java.io.Console;

/**
 * Absolute value via bit manipulation
 * http://www.geeksforgeeks.org/compute-the-integer-absolute-value-abs-without-branching/
 *
 * @author Oreste Luci
 */
public class AbsoluteValue {

    public static void main(String[] args) {

        Console console = System.console();

        System.out.println("Enter the number:");
        int number = Integer.parseInt(console.readLine());

        System.out.println(abs(number));
    }

    public static int abs(int number) {

        int mask = number >> 31;

        int result = (mask + number)  ^ mask;

        return result;
    }
}
