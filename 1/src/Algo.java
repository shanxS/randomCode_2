import lombok.Getter;
import lombok.Setter;

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
        tree.makeThreaded();
        tree.print();
        System.out.println("------");
        tree.printInOrder();
    }
}


class BST {
    private Node head;

    public void printInOrder() {
        Node node = goLeftDeep(head);

        while (node != null) {
            System.out.print(node.getValue() + " ");

            if (node.isLeaf()) {
                node = node.getRight();
            } else {
                node = goLeftDeep(node.getRight());
            }
        }
    }

    private Node goLeftDeep(Node node) {
        if (node == null) {
            return null;
        }

        while (node.getLeft() != null) {
            node = node.getLeft();
        }

        return node;
    }

    public void makeThreaded()  {
        makeThreaded(head, null);
    }


    private void makeThreaded(Node node, Node succ) {

        if (node == null) {
            return;
        }

        makeThreaded(node.getLeft(), node);
        if (node.getRight() == null) {
            node.setRight(succ);
            node.setLeaf(true);
        } else {
            makeThreaded(node.getRight(), succ);
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
        System.out.print(" | ");
        if (node.isLeaf()) {
            System.out.print("is leaf");
        }
        System.out.println();

        if (!node.isLeaf()) {
            print(node.getLeft());
            print(node.getRight());
        }
    }

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
                node.setLeaf(false);
                node.setRight(new Node(val));
            } else {
                insert(node.getRight(), val);
            }
        } else if (node.getValue() > val) {
            if (node.getLeft() == null) {
                node.setLeaf(false);
                node.setLeft(new Node(val));
            } else {
                insert(node.getLeft(), val);
            }
        } else {
            System.out.print("duplicate values " + val);
        }
    }
}

class Node {
    @Getter @Setter
    private Node left, right;

    @Getter
    private Integer value;

    @Getter @Setter
    private boolean isLeaf;

    public Node(int val) {
        this.value = val;
        isLeaf = true;
    }


}