import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] A1 = {1, 3, 4, 5, 7};
    private Integer[] A2 = {2, 3, 5, 6};

    public void run() {
        BST bst = new BST();

        for (Integer ele : A1) {
            bst.insert(ele);
        }
        for (Integer ele : A2) {
            bst.insert(ele);
        }

        bst.printUnion();
        System.out.println();
        bst.printIntersection();

    }
}

class BST {
    private Node head;
    private Set<Integer> intersection;

    public BST() {
        intersection = new HashSet<>();
    }

    public void insert(Integer value) {
        if (head == null) {
            head = new Node(value);
        } else {
            insert(head, value);
        }
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

    public void printIntersection() {
        for (Integer ele : intersection) {
            System.out.print(ele + " ");
        }
    }

    public void printUnion() {
        print(head);
    }

    private void print(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.getValue() + " ");
        print(node.getLeft());
        print(node.getRight());
    }
}

class Node {
    private Node left, right;
    private Integer value;

    public Node (Integer value) {
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