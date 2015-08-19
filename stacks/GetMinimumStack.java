/**
 * @author Oreste Luci
 */
public class GetMinimumStack {

	private StackItem top = null;
	private StackItem minimum = null;

	public void push(StackItem item) {

		item.next = this.top;
		this.top = item;

		if (this.minimum == null) {
			this.minimum = item;
		} else if (this.minimum.value.compareTo(item.value) > 0) {
			this.minimum = item;
		}
	}

	public StackItem pop() {

		StackItem item = this.top;
		this.top = this.top.next;

		if (item == minimum) {
			reassignMinimum();
		}

		item.next = null;
		return item;
	}

	public StackItem getMinimum() {
		return this.minimum;
	}

	private void reassignMinimum() {

		this.minimum = this.top;

		while (this.top.next != null) {

			StackItem next = top.next;

			if (this.minimum.value.compareTo(next.value) > 0) {
				this.minimum = next;
			}

			this.top = top.next;
		}
	}

	public class StackItem {
		public Integer value;
		public StackItem next;
	}

	public static void main(String[] args) {

		GetMinimumStack stack = new GetMinimumStack();

		stack.addStack(stack,10);
		System.out.println(stack.getMinimum()!=null?stack.getMinimum().value:"NULL");

		stack.addStack(stack,1);
		System.out.println(stack.getMinimum()!=null?stack.getMinimum().value:"NULL");

		stack.pop();

		stack.addStack(stack,5);
		System.out.println(stack.getMinimum()!=null?stack.getMinimum().value:"NULL");

		stack.addStack(stack,2);
		System.out.println(stack.getMinimum()!=null?stack.getMinimum().value:"NULL");

		stack.pop();

		stack.addStack(stack,30);
		System.out.println(stack.getMinimum()!=null?stack.getMinimum().value:"NULL");

		stack.printStack();
	}

	public void addStack(GetMinimumStack stack, int number) {
		GetMinimumStack.StackItem item = stack.new StackItem();
		item.value = new Integer(number);
		stack.push(item);
	}

	public void printStack() {

		StackItem item = this.top;
		while (item != null) {
			System.out.print(item.value + " ");
			item = item.next;
		}
	}
}
