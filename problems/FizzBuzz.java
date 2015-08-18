import java.io.Console;

public class FizzBuzz {

	public static void main(String[] args) {

		FizzBuzz fizzbuzz = new FizzBuzz();
		fizzbuzz.run();
	}

	private void run() {

		System.out.println("Enter the number: ");

		Console console = System.console();
		String numberStr = console.readLine();

		int number = Integer.parseInt(numberStr);
		boolean printNumber = true;

		for (int i=1; i<=number; i++) {

			// If divisable by 3 Fizz
			if ( i % 3 == 0) {
				System.out.print("Fizz");
				printNumber = false;
			}

			// If divisable by 5 Buzz
			if ( i % 5 == 0) {
				System.out.print("Buzz");
				printNumber = false;
			}

			if (printNumber) {
				System.out.print(i);	
			}
			
			printNumber = true;

			System.out.println(" ");
		}
	}

}