import lombok.*;
import java.util.*;

public class Algo {

    private int[] A = {
            1000,
            700, 1010,
            500,800,1020,
            400,600,900,
            550,850,950,
            530,570,970
    };
    /*{100,
    50, 200,
    40, 70, 300,
    60, 80, 400,
    350,500,
    320, 380};*/

    public void run() {

        BST tree = new BST();
        for (Integer i : A) {
            tree.insert(i);
        }

        tree.print();
        System.out.println("------");
        tree.printInorder();
    }
}

class BST {
    private Node head;

    public void insert(int val) {
        if (head == null) {
            head = new Node(val);
        } else {
            insert(head, val);
        }
    }

    public void printInorder() {
        Stack<Node> stack = new Stack<>();

        prep(stack, head);


        while (stack.size() > 0) {
            Node topNode = stack.pop();
            System.out.print(topNode.getValue() + " ");

            prep(stack, topNode.getRight());
        }

    }

    private void prep(Stack<Node> stack, Node cursor) {
        while (cursor != null) {
            stack.push (cursor);
            cursor = cursor.getLeft();
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
                insert(node.getLeft() , val);
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
    @Getter @Setter
    private Node left, right;

    @Getter
    private Integer value;

    public Node(int val) {
        this.value = val;
    }
}