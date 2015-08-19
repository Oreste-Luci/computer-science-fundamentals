import java.io.Console;
import java.math.BigInteger;

/**
 * Different ways of calculating the Factorial of a number
 */
public class Factorial {

	public static void main(String[] args) {

		System.out.println("Enter number: ");
		Console console = System.console();

		String numberStr = console.readLine();

		long number = Long.parseLong(numberStr);

		System.out.println("BigInteger:           " + factorialBig(number));

		System.out.println("BigInteger Recursive: " + factorialRecursive(new BigInteger(""+number)));

		System.out.println("Long:                 " + factorial(number));
	}

	/**
	 * Least performing since the biggest number the long data type will fit is 9223372036854775807
	 */
	public static long factorial(long number) {

		// IF number bigger than 20 it will not fit into a long
		if (number > 20) {
			return -1;
		}

		long result = 1;
		for (int i=1; i<=number; i++) {
			result *= i;
		}

		return result;
	}

	public static BigInteger factorialBig(long number) {

		BigInteger result = BigInteger.ONE;

		for (int i=1; i<=number; i++) {
			result = result.multiply(new BigInteger("" + i));
		}

		return result;
	}

	public static BigInteger factorialRecursive(BigInteger number) {

		if (number.compareTo(BigInteger.ZERO)==0) {
			return BigInteger.ONE;
		} else {
			return number.multiply(factorialRecursive(number.subtract(BigInteger.ONE)));
		}
	}
}
