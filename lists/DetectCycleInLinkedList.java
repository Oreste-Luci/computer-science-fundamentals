/**
 * Determines if a linked list has a loop.
 *
 * @author Oreste Luci
 */
public class DetectCycleInLinkedList {


	public static void main(String[] args) {

		DetectCycleInLinkedList detect = new DetectCycleInLinkedList();
		detect.run();

	}

	public void run() {

		Node<String> head = generateList();

		System.out.println(hasCycle(head));

		Node<String> one = new Node<>("1",null);

		System.out.println(hasCycle(one));

		Node<String> two = new Node<>("2",one);
		one.next = two;

		System.out.println(hasCycle(one));
	}

	/**
	 * It uses two pointers. One advances in one step the other in two.
	 * If the second one catches up with the first it then has a Cycle.
	 */
	public boolean hasCycle(Node<String> head) {

		Node<String> slowCounter, fastCounter;
		slowCounter = head;
		fastCounter = head;

		while (slowCounter.next != null) {

			slowCounter = slowCounter.next;

			if (fastCounter.next == null) {
				return false;
			}

			fastCounter = fastCounter.next.next;

			if (slowCounter.value == fastCounter.value) {
				return true;
			}
		}

		return false;
	}

	private Node<String> generateList() {

		Node<String> e = new Node<>();
		e.value = "E";

		Node<String> d = new Node<>("D",e);
		Node<String> c = new Node<>("C",d);
		Node<String> b = new Node<>("B",c);
		Node<String> a = new Node<>("A",b);

		e.next = b;
		//e.next = null;
		//d.next = c;

		return a;
	}


	public class Node<E> {

		public E value;
		public Node<E> next;

		public Node(E value, Node<E> next) {
			this.value = value;
			this.next = next;
		}

		public Node() {}
	}
}
