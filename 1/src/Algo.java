import lombok.*;

public class Algo {

    private int[] A = {100, 50, 110, 25, 60};

    public void run() {
        BST tree = new BST();
        for (Integer i : A) {
            tree.insert(i);
        }

        tree.print();
    }
}


class BST{

    private Node head;

    public void insert(int val) {
        if (head == null) {
            head = new Node (val);
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
                node.setLeft(new Node (val));
            } else {
                insert(node.getLeft(), val);
            }
        } else {
            System.out.print("duplicate value found for " + val);
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


class Node{

    @Getter @Setter
    private Node left, right;

    @Getter
    private Integer value;

    public Node (int v) {
        this.value = v;
    }
}
