
import java.util.Stack;

/**
* Reverses a Linked List
*/
public class ReverseLinkedList {


	public static void main(String[] args) {

		ReverseLinkedList rll = new ReverseLinkedList();

		Node<String> head = rll.createList();
		head = rll.reverseListWithStack(head);
		rll.printList(head);


		System.out.println(" ");

		head = rll.createList();
		head = rll.reverseListIter(head);
		rll.printList(head);

		System.out.println(" ");

		head = rll.createList();
		head = rll.recursiveReverse(null,head);
		rll.printList(head);
	}

	public Node<String> recursiveReverse(Node<String> previous, Node<String> current) {

		if (current.next == null) {

			current.next = previous;
			return current;

		} else {

			Node<String> next = current.next;
			current.next = previous;

			return recursiveReverse(current,next);
		}

	}

	public Node<String> reverseListIter(Node<String> head) {

		if (head == null) {
			return null;
		}

		Node<String> node1, node2;

		node1 = head.next;
		node2 = node1.next;

		node1.next = head;
		head.next = null;


		while(node2 != null) {
			head = node1;
			node1 = node2;
			node2 = node2.next;

			node1.next = head;
		}

		return node1;
	}

	public Node<String> reverseListWithStack(Node<String> head) {

		if (head == null) {
			return null;
		}

		Stack<String> stack = new Stack<>();

		stack.push(head.value);

		while(head.next!=null) {
			head = head.next;
			stack.push(head.value);
		}

		Node<String> reversedHead = null;
		Node<String> node = new Node<>();

		node.value = stack.pop();

		reversedHead = node;

		while(!stack.empty()) {

			node.next = new Node<>();
			node = node.next;
			node.value = stack.pop();
		}

		return reversedHead;
	}

	private Node<String> createList() {

		Node<String> node = new Node<>("a");
		Node<String> head;
		head = node;
		node.next = new Node<String>("b");
		node = node.next;
		node.next = new Node<String>("c");
		node = node.next;
		node.next = new Node<String>("d");
		node = node.next;
		node.next = new Node<String>("e");

		return head;
	}

	private void printList(Node<String> head) {

		if (head == null) {
			System.out.println("List is empty");
			return;
		}

		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}

	public class Node<E> {

		public E value;
		public Node<E> next;

		public Node(E val) {
			this.value = val;
		}

		public Node() {}
	}
}