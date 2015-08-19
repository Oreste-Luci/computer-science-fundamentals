import java.util.Stack;

/**
 * Iterative Tree Tranversals Using Stack
 */
public class IterativeTranversal {

    public static void main(String[] args) {

        IterativeTranversal tranversal = new IterativeTranversal();

        Node root = tranversal.createTree();

        System.out.print("In-Order:   ");
        tranversal.inOrder(root);

        System.out.print("\nPre-Order:  ");
        tranversal.preOrder(root);

        System.out.print("\nPost-Order: ");
        tranversal.postOrder(root);
    }

    /**
     * Left, Visit, Right
     */
    public void inOrder(Node node) {

        if (node == null) {
            System.out.println("Tree is empty");
            return;
        }

        Stack<Node> stack = new Stack<>();

        stack.push(node);

        do {

            if (node.left != null) {
                node = node.left;
                stack.push(node);
            } else {
                node = stack.pop();
                System.out.print(node.value + " ");
                if (node.right != null) {
                    node = node.right;
                    stack.push(node);
                }
            }
        } while (!stack.empty());
    }

    /**
     * Visit, Left, Right
     */
    public void preOrder(Node node) {

        if (node == null) {
            System.out.println("Tree is empty");
            return;
        }

        Stack<Node> stack = new Stack<>();

        stack.push(node);

        while (!stack.empty()) {

            node = stack.pop();
            System.out.print(node.value + " ");

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * Left, Right, Visit
     * Need to use two stacks here
     */
    public void postOrder(Node node) {

        if (node == null) {
            System.out.println("Tree is empty");
            return;
        }

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(node);

        while (!stack1.empty()) {

            node = stack1.pop();

            stack2.push(node);

            if (node.left != null) {
                stack1.push(node.left);
            }

            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.empty()) {
            node = stack2.pop();
            System.out.print(node.value + " ");
        }
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
