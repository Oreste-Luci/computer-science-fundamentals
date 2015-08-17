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

			if (c == '(' || c == '{' || c == '[') {

				stack.push("" + c);

			} else {

				if (stack.empty()) {
					return false;
				}

				String lastDelim = stack.pop();

				if (c == ')' && lastDelim.charAt(0) != '(') {
					
					return false;

				} else if (c == ']' && lastDelim.charAt(0) != '[') {

					return false;

				} else if (c == '}' && lastDelim.charAt(0) != '{') {

					return false;
				}
			}

		}

		if (!stack.empty()) {
			return false;
		}

		return true;
	}
}