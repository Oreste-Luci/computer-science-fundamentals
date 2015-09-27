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

        System.out.println("Number: " + Integer.toBinaryString(number));
        System.out.println("Mask: " + Integer.toBinaryString(mask));
        System.out.println("Mask + Number: " + Integer.toBinaryString(mask + number));
        System.out.println("(Mask + Number) ^ Mask: " + Integer.toBinaryString((mask + number)^mask));

        int result = (mask + number)  ^ mask;

        return result;
    }
}
