import java.util.ArrayDeque;

public class BinaryCode {

    private int[] A = {10,2,7,8,4,13};

    public void run() {

        BT bt = new BT();

        for (Integer ele : A) {
            bt.insert(ele);
        }

        bt.print();

   }

}

class BT {

    private Node head;
    private ArrayDeque<Node> startD, otherD;

    public void insert(Integer value) {
        if (head == null) {
            head = new Node(value);
        } else {
            insertChildren(value);
        }
    }

    private void insertChildren(Integer value) {
        ArrayDeque<Node> d1;
        if (startD == null) {
            d1 = new ArrayDeque<>();
            d1.addLast(head);
        } else {
            d1 = startD;
        }

        ArrayDeque<Node> d2 = (otherD == null) ? new ArrayDeque<>() : otherD;

        while (true) {
            if (processFor(d1, d2, value)) {
                return;
            }

            if (processFor(d2, d1, value)) {
                return;
            }
        }
    }

    private boolean processFor(ArrayDeque<Node> d1, ArrayDeque<Node> d2, Integer value) {
        while (d1.size() > 0) {
            Node node = d1.removeLast();

            if (node.getLeft() != null) {
                d2.addFirst(node.getLeft());
            } else {
                node.setLeft(new Node(value));

                d1.addLast(node);
                startD = d1;
                otherD = d2;

                return true;
            }

            if (node.getRight() != null) {
                d2.addFirst(node.getRight());
            } else {
                node.setRight(new Node(value));

                d2.removeFirst();
                d1.addLast(node);
                startD = d1;
                otherD = d2;

                return true;
            }
        }

        return false;
    }

    public void print() {
        print(head);
    }

    private void print(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.getValue() + " - ");
        if (node.getLeft() != null) {
            System.out.print(node.getLeft().getValue());
        }
        System.out.print(", ");
        if (node.getRight() != null) {
            System.out.print(node.getRight().getValue());
        }
        System.out.println();

        print(node.getLeft());
        print(node.getRight());
    }

}


class Node {
    private Node left, right;
    private Integer value;

    public Node(Integer value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Integer getValue() {
        return value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}