/**
 * @author Oreste Luci
 */
public class LinkedList {

	public static void main(String[] args) {

		System.out.println("LinkedList Example of length: " + args[0]);

		LinkedList linkedList = new LinkedList();

		Node node = linkedList.createList((new Integer(args[0])).intValue());

		linkedList.printList(node);
	}

	private Node createList(int length) {

		Node first = null;
		Node previous = null;
		for (int i=1; i<=length; i++) {

			Node node = new Node();
			node.setValue("" + i);

			if (first == null) {
				first = node;
			}

			if (previous!=null) {
				previous.setNext(node);
			}

			previous = node;
		}

		return first;
	}

	private void printList(Node node) {

		if (node == null) {
			System.out.println("List is empty");
			return;
		}

		System.out.print(node.getValue() + " ");

		while (node.getNext()!=null) {
			node = node.getNext();
			System.out.print(node.getValue() + " ");
		}
	}

	public class Node {

		private String value;
		private Node next;

		public String getValue() {
			return this.value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public void setNext(Node node) {
			this.next = node;
		}

		public Node getNext() {
			return this.next;
		}
	}
}
