import java.util.ArrayList;
import java.util.List;

public class BinaryCode {

    private Integer[] A = {7, 1, 5, 2, 3, 6};
    private Integer[] B = {3, 8, 6, 20, 7};

    public void run() {
        BST bst = new BST();

        for (Integer ele : A) {
            bst.insert(ele);
        }
        for (Integer ele : B) {
            bst.insert(ele);
        }

        bst.printIntersection();
        System.out.println("-----");
        bst.printUnion();

    }
}

class BST {
    private Node head;
    private List<Integer> intersection;

    public BST() {
        intersection = new ArrayList<>();
    }

    public void insert(Integer value) {
        if (head == null) {
            head = new Node(value);
        } else {
            insert(head, value);
        }
    }

    public void printIntersection() {
        intersection.forEach(val -> System.out.print(val + " "));
    }

    public void printUnion() {
        print(head);
    }

    private void print(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.getValue() + " ");
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

    private void insert(Node node, Integer value) {
        if (node.getValue() > value) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(value));
            } else {
                insert(node.getLeft(), value);
            }
        } else if (node.getValue() < value) {
            if (node.getRight() == null) {
                node.setRight(new Node(value));
            } else {
                insert(node.getRight(), value);
            }
        } else {
            intersection.add(value);
        }
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

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Integer getValue() {
        return value;
    }
}