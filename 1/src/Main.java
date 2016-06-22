import lombok.*;

public class Main {
    public static void main(String[] args) {
        Algo algo = new Algo();
        algo.run();
    }
}

class Algo {

    private int[] A = {
            100,
            50,110,
            20,60,120,
            10,55,70,115,130,
            5,140

//            1000,
//            700, 1010,
//            500,800,1020,
//            400,600,900,
//            550,850,950,
//            530,570,970
    };

    public void run() {

        BST tree = new BST();
        for (Integer i : A) {
            tree.insert(i);
        }
        tree.print();

        LevelConnector lc = new LevelConnector();
        lc.connect(tree.getHead());
        System.out.print("=========");
        tree.print();

    }
}

class LevelConnector {
    public void connect(Node node) {
        if(node == null) {
            return;
        }

        if (node.getLeft() != null) {
            if (node.getRight() != null) {
                node.getLeft().setNextRight(node.getRight());
            } else {
                node.getLeft().setNextRight(drillNextRights(node.getNextRight()));
            }
        }
        if (node.getRight() != null) {
            node.getRight().setNextRight(drillNextRights(node.getNextRight()));
        }

        connect(node.getRight());
        connect(node.getLeft());

    }

    private Node drillNextRights(Node node) {
        if (node == null) {
            return null;
        }

        if (node.getLeft() != null) {
            return node.getLeft();
        } else if (node.getRight() != null) {
            return node.getRight();
        } else {
            return drillNextRights(node.getNextRight());
        }
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
            System.out.print("duplicate value" + val);
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
        if (node.getNextRight() != null) {
            System.out.print(node.getNextRight().getValue());
        }
        System.out.println();

        print(node.getLeft());
        print(node.getRight());
    }


}

class Node {
    @Getter @Setter
    private Node left, right, nextRight;


    @Getter @Setter
    private Integer value;

    public Node(int val) {
        this.value = val;
    }
}