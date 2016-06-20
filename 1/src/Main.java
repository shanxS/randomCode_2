import lombok.*;

public class Main {

    private static Algo algo;

    public static void main(String[] args) {
        algo = new Algo();
        algo.run();

    }

}

class Algo {

    private int[] A = {
            1000,
            700, 1010,
            500,800,1020,
            400,600,900,
            550,850,950,
            530,570,970
    };

    public void run() {
        BST tree = new BST();

        for (Integer i : A) {
            tree.insert(i);
        }

        tree.print();
        System.out.println("----");
        tree.printInorder();

    }
}


class BST {

    private Node head;


    public void printInorder() {

        Node node = goLeftBottom(head);

        while (node != null) {
            System.out.print(node.getValue() + " ");

            if (node.isThreaded()) {
                node = node.getRight();
            } else {
                node = goLeftBottom(node.getRight());
            }
        }
    }

    private Node goLeftBottom(Node node) {
        if (node == null) {
            return null;
        }

        while(node.getLeft() != null) {
            node = node.getLeft();
        }

        return node;

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

            if (node.isThreaded()) {
                System.out.print(" | is leaf");
            }
        }
        System.out.println();

        print(node.getLeft());
        if (!node.isThreaded()) {
            print(node.getRight());
        }
    }

    public void insert(int val) {

        if (head == null) {
            head = new Node(val);
        } else {
            insert(head, null, val);
        }
    }

    private void insert(Node node, Node succ, int val) {
        if (node.getValue() > val) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(val));

                node.getLeft().setThreaded(true);
                node.getLeft().setRight(node);
            } else {
                insert(node.getLeft(), node, val);
            }
        } else if (node.getValue() < val) {
            if (node.isThreaded() || node.getRight() == null) {
                node.setRight(new Node(val));
                node.setThreaded(false);
                if (succ != null) {
                    node.getRight().setThreaded(true);
                    node.getRight().setRight(succ);
                }

            } else {
                insert(node.getRight(), succ, val);
            }
        }

    }
}


class Node {

    @Getter @Setter
    private Node left, right;

    @Getter @Setter
    private Integer value;

    @Getter @Setter
    private boolean isThreaded;


    public Node (int val) {
        this.value = val;
        this.isThreaded = false;
    }
}