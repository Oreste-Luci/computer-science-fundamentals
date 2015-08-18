import java.util.Stack;

public class BalancedDelimiters {

	public static void main(String[] args) {

		String delimiters = "([{}])";
		System.out.println(delimiters + " " + balanced(delimiters));

		delimiters = "()";
		System.out.println(delimiters + " " + balanced(delimiters));

		delimiters = "}{";
		System.out.println(delimiters + " " + balanced(delimiters));

		delimiters = "(){";
		System.out.println(delimiters + " " + balanced(delimiters));

		delimiters = "(";
		System.out.println(delimiters + " " + balanced(delimiters));

		delimiters = "";
		System.out.println(delimiters + " " + balanced(delimiters));

		delimiters = "((({[{[]}]})))";
		System.out.println(delimiters + " " + balanced(delimiters));

		delimiters = "[(){}[{}][]]";
		System.out.println(delimiters + " " + balanced(delimiters));
	}

	public static boolean balanced(String delimiters) {

		Stack<String> stack = new Stack<>();

		for (int i=0; i<delimiters.length(); i++) {

			char c = delimiters.charAt(i);

			if (isOpener(c)) {

				stack.push("" + c);

			} else {

				if (stack.empty()) {
					return false;
				}

				String lastDelim = stack.pop();

				if (!isCloserFor(lastDelim.charAt(0),c)) {
					return false;
				}
			}

		}

		if (!stack.empty()) {
			return false;
		}

		return true;
	}

	public static boolean isOpener(char c) {

		if (c == '(' || c == '{' || c == '[') {
			return true;
		}

		return false;
	}

	public static boolean isCloserFor(char opener, char closer) {

		if (opener == '(' && closer == ')') {
			
			return true;

		} else if (opener == '[' && closer == ']') {

			return true;

		} else if (opener == '{' && closer == '}') {

			return true;

		} else {

			return false;
		}
	}
}