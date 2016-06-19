import lombok.*;

public class Algo {

    private int[] A = {
            1000,
            700, 1010,
            500,800,1020,
            400,600,900,
            550,850,950,
            530,570,9703
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
        System.out.print(tree.findDia());
    }
}

class BST {

    private Node head;

    private int dia;

    public int findDia() {
        dia = 0;

        int leftDepth = findDepth(head.getLeft());
        int rightDepth = findDepth(head.getRight());

        dia = Math.max (dia, (leftDepth + rightDepth + 1));

        return dia;
    }

    private int findDepth(Node node) {
        if (node == null) {
            return 0;
        }

        if (node.getLeft() == null && node.getRight() == null) {
            return 1;
        }

        int leftDepth = findDepth(node.getLeft());
        int rightDepth = findDepth(node.getRight());

        dia = Math.max (dia, (leftDepth + rightDepth + 1));

        return 1 + Math.max(leftDepth, rightDepth);
    }

    public void insert(int val) {
        if (head == null) {
            head = new Node (val);
        } else {
            insert(head, val);
        }
    }

    public void insert(Node node, int val) {
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
            System.out.print("same value " + val);
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

    public Node(Integer val) {
        this.value = val;
    }
}