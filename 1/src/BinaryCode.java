import java.util.Stack;

public class BinaryCode {


    private Node head;

    public void run() {
        init();

        print();

    }

    private void print() {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(head);
        while (s1.size() > 0 || s2.size() > 0) {
            while (s1.size() > 0) {
                Node node = s1.pop();

                System.out.print(node.getValue() + " ");

                if (node.getRight() != null) {
                    s2.push(node.getRight());
                }

                if (node.getLeft() != null) {
                    s2.push(node.getLeft());
                }
            }
            System.out.println();

            while (s2.size() > 0) {
                Node  node = s2.pop();

                System.out.print(node.getValue() + " ");

                if (node.getRight() != null) {
                    s1.push(node.getRight());
                }

                if (node.getLeft() != null) {
                    s1.push(node.getLeft());
                }
            }

            System.out.println();
        }
    }

    private void init() {
        head = new Node(10);
        head.setLeft(new Node(2));
        head.setRight(new Node(7));

        head.getLeft().setLeft(new Node(8));
        head.getLeft().setRight(new Node(4));
    }

}

class Node {
    private Node left, right;
    private int value;

    public Node(int value) {
        this.value = value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }
}