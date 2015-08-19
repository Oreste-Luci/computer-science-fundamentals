
/**
 * Find the height of a Binary Tree. If only one node height is 0.
 *
 * @author Oreste Luci
 */
public class BSTHeight {

	public static void main(String[] args) {

		BSTHeight bst = new BSTHeight();

		bst.testCase1();
		bst.testCase2();
		bst.testCase3();
		bst.testCase4();
		bst.testCase5();
	}

	public class Node {
		public int value;
		public Node leftChild;
		public Node rightChild;

		public Node(int value) {
			this.value = value;
		}
	}

	public int treeHeight(Node node) {

		if (node == null) {
			return -1;
		}

		if (node.leftChild == null && node.rightChild == null) {
			return 0;
		}

		return 1 + Math.max(treeHeight(node.leftChild),treeHeight(node.rightChild));
	}

	public void testCase1() {

		Node a = new Node(10);
		Node b = new Node(9);
		a.leftChild = b;

		Node c = new Node(8);
		b.leftChild = c;

		System.out.println("Heigh (2): " + treeHeight(a));
	}

	public void testCase2() {
		Node a = new Node(10);
		System.out.println("Heigh (0): " + treeHeight(a));
	}

	public void testCase3() {
		System.out.println("Heigh (na): " + treeHeight(null));
	}

	public void testCase4() {

		Node a = new Node(10);
		Node b = new Node(5);
		Node c = new Node(15);

		a.leftChild = b;
		a.rightChild = c;

		System.out.println("Heigh (1): " + treeHeight(a));
	}

	public void testCase5() {

		Node a = new Node(10);
		Node b = new Node(5);
		Node c = new Node(15);
		Node d = new Node(16);

		a.leftChild = b;
		a.rightChild = c;
		c.rightChild = d;

		System.out.println("Heigh (2): " + treeHeight(a));
	}

}
