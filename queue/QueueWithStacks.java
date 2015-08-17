import java.util.ArrayList;
import java.util.Stack;

/**
* This class implements a Queue with two stacks
*/
public class QueueWithStacks {
	

	private Stack<String> stack1 = new Stack<>();
	private Stack<String> stack2 = new Stack<>();

	public static void main(String[] args) {

		QueueWithStacks qws = new QueueWithStacks();

		System.out.println(qws.dequeue());
		qws.enqueue("a");
		qws.enqueue("b");
		qws.enqueue("c");
		System.out.println(qws.dequeue());
		qws.enqueue("d");
		System.out.println(qws.dequeue());
		System.out.println(qws.dequeue());
		System.out.println(qws.dequeue());
		System.out.println(qws.dequeue());
	}

	public void enqueue(String value) {
		if (value != null) {
			stack1.push(value);
		}
	}

	public String dequeue() {

		String value = null, returnValue = null;

		while (!stack1.empty()) {
			value = stack1.pop();
			stack2.push(value);
		}

		if (!stack2.empty()) {

			returnValue = stack2.pop();

			while(!stack2.empty()) {

				value = stack2.pop();
				stack1.push(value);
			}
		}

		return returnValue;
	}

}