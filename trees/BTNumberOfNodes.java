/**
 * Count the number of nodes on a binary tree
 */
public class BTNumberOfNodes {

	public static void main(String[] args) {

		BTNumberOfNodes numNodes = new BTNumberOfNodes();

		numNodes.testCase1();
		numNodes.testCase2();
		numNodes.testCase3();
	}

	public class Node {

		public int value;
		public Node leftChild;
		public Node rightChild;

		public Node(int value) {
			this.value = value;
		}
	}

	public int numberOfNodes(Node node) {

		if (node == null) {
			return 0;
		}

		return 1 + numberOfNodes(node.leftChild) + numberOfNodes(node.rightChild);
	}

	public void testCase1() {
		Node n1 = new Node(1);
		System.out.println("Test (1): " + numberOfNodes(n1));
	}

	public void testCase2() {
		Node n10 = new Node(10);
		Node n15 = new Node(15);
		Node n5 = new Node(5);

		n10.leftChild = n5;
		n10.rightChild = n15;

		System.out.println("Test (3): " + numberOfNodes(n10));
	}	


	public void testCase3() {
		Node n10 = new Node(10);
		Node n15 = new Node(15);
		Node n12 = new Node(12);
		Node n17 = new Node(17);

		Node n8 = new Node(8);
		Node n9 = new Node(9);
		Node n4 = new Node(4);

		n10.leftChild = n8;
		n10.rightChild = n15;

		n8.leftChild = n4;
		n8.rightChild = n9;

		n15.leftChild = n12;
		n15.rightChild = n17;

		System.out.println("Test (7): " + numberOfNodes(n10));
	}	

}