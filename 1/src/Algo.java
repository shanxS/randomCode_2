/**
 * @author shashaku on 29/03/16.
 */
public class Algo {
    private Integer[] A = {6, 5, 3, 1, 8, 7, 2, 4};
    private Integer k = 4;//3;
    public void run() {

        BST tree = new BST();
        for (Integer ele : A) {
            tree.add(ele);
        }

        tree.print();

    }
}

class BST {
    private Node head;

    public void add (Integer value) {
        if (head == null) {
            head = new Node(value);
        } else {
            insert(head, value);
        }
    }

    public void print() {
        print(head);
    }

    private void print(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.getData() + " - ");
        if (node.getLeft() != null) {
            System.out.print(node.getLeft().getData());
        }
        System.out.print(", ");
        if (node.getRight() != null) {
            System.out.print(node.getRight().getData());
        }
        System.out.println();

        print(node.getLeft());
        print(node.getRight());

    }

    private void insert(Node node, Integer value) {
        if (node.getData() > value) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(value));
            } else {
                insert(node.getLeft(), value);
            }
        } else if (node.getData() < value) {
            if (node.getRight() == null) {
                node.setRight(new Node(value));
            } else {
                insert(node.getRight(), value);
            }
        } else {
            System.out.println("same values");
        }
    }
}

class Node {
    private Node left, right;
    private Integer data;

    public Node(Integer data) {
        this.data = data;
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

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }
}