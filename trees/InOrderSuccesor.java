import java.util.*;

/**
 *
 * @author Oreste Luci
 */
public class InOrderSuccesor {

    public static void main(String[] args) {

        System.out.print("Enter node for which to find succesor: ");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();

        InOrderSuccesor is = new InOrderSuccesor();

        Node root = is.createTree();

        int successor = is.returnInorderSuccessor(root,value);

        println(successor);
    }

    public int returnInorderSuccessor(Node root, int value) {

        // First find Node with value usin binary search
        Node node = findNodeBS(root,value);

        // If node has right subtree
        if (node.right != null) {
            return findMin(node.right).value;
        }
        // No right subtree
        else {

            Node successor = null;
            Node ancestor = root;

            while (ancestor.value != node.value) {

                if (node.value < ancestor.value) {
                    successor = ancestor;
                    ancestor = ancestor.left;
                } else {
                    ancestor = ancestor.right;
                }
            }

            return successor.value;
        }
    }

    public Node findMin(Node root) {

        Node node = root;
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    /**
     * Find node using Binary Search
     */
    public Node findNodeBS(Node node, int value) {

        if (node == null) {
            throw new RuntimeException("Value not in tree");
        }

        if (node.value == value) {
            return node;
        } else if (value < node.value) {
            return findNodeBS(node.left,value);
        } else {
            return findNodeBS(node.right,value);
        }
    }

    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public Node createTree() {

        Node n32 = new Node(32);
        Node n38 = new Node(38);
        Node n35 = new Node(35,n32,n38);
        Node n50 = new Node(50);
        Node n40 = new Node(40,n35,n50);

        Node n22 = new Node(22);
        Node n23 = new Node(23);
        n23.left = n22;
        Node n28 = new Node(28);
        Node n25 = new Node(25,n23,n28);
        Node n30 = new Node(30,n25,n40);

        Node n5 = new Node(5);
        Node n15 = new Node(15);
        Node n10 = new Node(10,n5,n15);

        Node n20 = new Node(20,n10,n30);

        return n20;
    }

    public static void println(int value) {
        System.out.println(value + " ");
    }
}
