import java.util.ArrayDeque;

public class BinaryCode {

    private int[] A = {10,2,7,8,4};

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
            insert(head, value);
        }
    }

    private void insert(Node head, Integer value) {
        ArrayDeque<Node> d1 = (startD == null) ? new ArrayDeque<>() : startD;
        ArrayDeque<Node> d2 = (otherD == null) ? new ArrayDeque<>() : otherD;

        d1.push(head);

        while (true) {

            while (d1.size() > 0) {
                Node node = d1.removeLast();

                if (node.getLeft() != null) {
                    d2.push(node.getLeft());
                } else {
                    node.setLeft(new Node(value));

                    d1.push(node);
                    startD = d1;
                    otherD = d2;

                    return;
                }

                if (node.getRight() != null) {
                    d2.push(node.getRight());
                } else {
                    node.setRight(new Node(value));

                    d1.push(node);
                    startD = d1;
                    otherD = d2;

                    return;
                }
            }


            while (d2.size() > 0) {
                Node node = d2.removeLast();

                if (node.getLeft() != null) {
                    d1.push(node.getLeft());
                } else {
                    node.setLeft(new Node(value));

                    d2.push(node);
                    startD = d2;
                    otherD = d1;

                    return;
                }

                if (node.getRight() != null) {
                    d1.push(node.getRight());
                } else {
                    node.setRight(new Node(value));

                    d2.push(node);
                    startD = d2;
                    otherD = d1;

                    return;
                }
            }
        }
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

    public Integer getValue() {
        return value;
    }
}