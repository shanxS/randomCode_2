import lombok.*;

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
            550,850,950,
            530,570,970
    };

    public void run() {
        BST tree = new BST();
        for (Integer i : A) {
            tree.insert(i);
        }

        tree.print();
        System.out.print("-----");
        Ancestory anc = new Ancestory();
        anc.printAncestors(tree.getHead(), 800);
    }
}

class Ancestory {
    public boolean printAncestors(Node node, int target) {
        if (node == null) {
            return false;
        }

        if (node.getValue() == target) {
            System.out.print(node.getValue() + " ");
            return true;
        } else if (printAncestors(node.getLeft(), target)) {
            System.out.print(node.getValue() + " ");
            return true;
        } else if (printAncestors(node.getRight(), target)) {
            System.out.print(node.getValue() + " ");
            return true;
        }

        return false;

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
        if (node.getValue() > val) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(val));
            } else {
                insert(node.getLeft(), val);
            }
        } else if (node.getValue() < val) {
            if (node.getRight() == null) {
                node.setRight(new Node(val));
            } else {
                insert(node.getRight(), val);
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
    @Setter @Getter
    private Node left, right;

    @Setter @Getter
    private Integer value;

    public Node (int val) {
        this.value = val;
    }
}