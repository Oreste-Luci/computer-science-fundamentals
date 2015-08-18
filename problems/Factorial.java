import java.io.Console;
import java.math.BigInteger;

public class Factorial {


	public static void main(String[] args) {

		System.out.println("Enter number: ");
		Console console = System.console();

		String numberStr = console.readLine();

		long number = Long.parseLong(numberStr);

		System.out.println(factorialBig(number));

		System.out.println(factorial(number));
	}

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
}