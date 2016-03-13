/**
 * @author Oreste Luci
 */
public class IsBinaryTree {

    public static void main(String[] args) {

        IsBinaryTree isBinaryTree = new IsBinaryTree();

        boolean isBinary = isBinaryTree.isBinary(isBinaryTree.createTree1());
        System.out.println(isBinary);

        isBinary = isBinaryTree.isBinary(isBinaryTree.createTree2());
        System.out.println(isBinary);

        isBinary = isBinaryTree.isBinary(isBinaryTree.createTree3());
        System.out.println(isBinary);
    }

    private boolean isBinary(Node tree) {
        return isBinarySubTree(tree.value, tree.left, "left") && isBinarySubTree(tree.value, tree.right, "right");
    }

    private boolean isBinarySubTree(int rootValue, Node node, String direction) {

        if (node == null) {
            return true;
        } else if ("right".equals(direction) && node.value < rootValue) {
            return false;
        } else if ("left".equals(direction) && node.value > rootValue) {
            return false;
        } else if ((node.left != null && node.left.value > node.value) || (node.right != null && node.right.value < node.value)) {
            return false;
        } else {
            return isBinarySubTree(rootValue, node.left, direction) && isBinarySubTree(rootValue, node.right, direction);
        }
    }

    private Node createTree1() {

        Node n20 = new Node(20);
        Node n13 = new Node(13);
        Node n15 = new Node(15,n13,n20);

        Node n1 = new Node(1);
        Node n6 = new Node(6);
        Node n5 = new Node(5,n1,n6);

        Node n10 = new Node(10,n5,n15);

        return n10;
    }

    private Node createTree2() {

        Node n150 = new Node(150);
        Node n80 = new Node(80);
        Node n120 = new Node(120,n80,n150);

        Node n60 = new Node(60);
        Node n50 = new Node(50,null,n60);

        Node n100 = new Node(100,n50,n120);

        return n100;
    }

    private Node createTree3() {

        Node n150 = new Node(150);
        Node n80 = new Node(80);
        Node n120 = new Node(120,n80,n150);

        Node n60 = new Node(60);
        Node n50 = new Node(50,null,n60);

        Node n100 = new Node(100,n120,n50);

        return n100;
    }


    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node() {}
        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public String toString() {
            String content = "[" + value +"," + left + "," + right + "]";
            return content;
        }
    }
}
