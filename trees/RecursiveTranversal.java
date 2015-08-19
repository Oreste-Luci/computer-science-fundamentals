
/**
 * Recursive Tree Tranversal
 */
public class RecursiveTranversal {

    public static void main(String[] args) {

        RecursiveTranversal tranversal = new RecursiveTranversal();

        Node root = tranversal.createTree();

        System.out.println("In-Order:   " + tranversal.inOrder(root));
        System.out.println("Pre-Order:  " + tranversal.preOrder(root));
        System.out.println("Post-Order: " + tranversal.postOrder(root));
    }

    /**
     * Left, Visit, Right
     */
    public String inOrder(Node node) {

        if (node == null ) {
            return "";
        }

        return inOrder(node.left) + node.value + " " + inOrder(node.right);
    }

    /**
     * Visit, Left, Right
     */
    public String preOrder(Node node) {

        if (node == null) {
            return "";
        }

        return node.value + " " + preOrder(node.left) + preOrder(node.right);
    }

    /**
     * Left, Right, Visit
     */
    public String postOrder(Node node) {

        if (node == null) {
            return "";
        }

        return postOrder(node.left) + postOrder(node.right) + node.value + " ";
    }

    public class Node {

        public String value;
        public Node left;
        public Node right;

        public Node(String value) {
            this.value = value;
        }
    }

    public Node createTree() {

        Node a = new Node("50");
        Node b = new Node("30");
        Node c = new Node("70");
        Node d = new Node("20");
        Node e = new Node("40");
        Node f = new Node("60");
        Node g = new Node("80");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        return a;
    }
}
