import lombok.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Algo algo = new Algo();
        algo.run();
    }
}

class Algo {
    private int[] A = {
            1000,
            700, 1010,
            500,800,1020,
            400,600,900,
            300, 550,850,950,
            530,570,970
    };

    public void run() {
        BST tree = new BST();

        for (Integer i : A) {
            tree.insert(i);
        }

        tree.print();
        System.out.println("------");
        WidthFinder wf = new WidthFinder();
        int width = wf.findMaxWidth(tree.getHead());
        System.out.print("------" + width);
    }
}

class WidthFinder {
    private int maxW;

    public int findMaxWidth (Node head) {
        maxW = Integer.MIN_VALUE;

        ArrayDeque<Node> q1 = new ArrayDeque<>();
        ArrayDeque<Node> q2 = new ArrayDeque<>();

        q1.addFirst(head);

        while (q1.size() > 0 || q2.size() > 0) {
            maxW = Math.max(maxW, q1.size());
            while (q1.size() > 0) {
                Node node = q1.removeFirst();

                System.out.print(node.getValue() + " ");
                if (node.getLeft() != null) {
                    q2.addLast(node.getLeft());
                }
                if (node.getRight() != null) {
                    q2.addLast(node.getRight());
                }
            }
            System.out.println();

            maxW = Math.max(maxW, q2.size());
            while (q2.size() > 0) {
                Node node = q2.removeFirst();

                System.out.print(node.getValue() + " ");
                if (node.getLeft() != null) {
                    q1.addFirst(node.getLeft());
                }
                if (node.getRight() != null) {
                    q1.addFirst(node.getRight());
                }
            }
            System.out.println();
        }

        return maxW;
    }
}

class BST {
    @Getter
    private Node head;

    public void insert(int val) {
        if (head == null) {
            head = new Node(val);
        } else {
            insert(head, val);
        }
    }

    private void insert(Node node, int val) {
        if (node.getValue() < val) {
            if (node.getRight() == null) {
                node.setRight(new Node(val));
            } else {
                insert(node.getRight(), val);
            }
        } else if (node.getValue() > val) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(val));
            } else {
                insert(node.getLeft(), val);
            }
        } else {
            System.out.print("duplicate value " + val);
        }
    }

    public void print() {
        print(head);
    }

    private void print(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.getValue() + " - " );
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
    @Getter @Setter
    private Node left, right;

    @Getter @Setter
    private Integer value;

    public Node(int val) {
        this.value = val;
    }
}