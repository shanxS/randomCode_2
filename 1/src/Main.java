import lombok.*;

public class Main {

    public static void main(String[] args){
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


        tree.connect(700, 970);
        tree.connect(850, 1020);
        tree.connect(570, 1000);
        tree.connect(700, 600);
        tree.print();
        System.out.print("---------");

        TreeCopier tc = new TreeCopier();
        Node copy = tc.copy(tree.getHead());
        BST.print(tree.getHead());
        System.out.print("---------");
        BST.print(copy);
    }
}

class TreeCopier {
    public Node copy(Node from) {
        insertCopies(from);
        copyRandomPointers(from);

        Node copyHead = from.getLeft();

        detachCopy(from);

        return copyHead;
    }

    private void detachCopy(Node from) {
        if (from == null) {
            return;
        }

        Node to = from.getLeft();
        from.setLeft(to.getLeft());

        if (to.getLeft() != null) {
            to.setLeft(to.getLeft().getLeft());
        }

        detachCopy(from.getLeft());
        detachCopy(from.getRight());

    }

    private void copyRandomPointers(Node from) {
        if (from == null) {
            return;
        }

        copyRandomPointers(from.getLeft().getLeft());
        copyRandomPointers(from.getRight());

        if (from.getRandom() != null) {
            from.getLeft().setRandom(from.getRandom().getLeft());
        }
    }

    private void insertCopies(Node from) {
        if (from == null) {
            return;
        }

        insertCopies(from.getLeft());
        insertCopies(from.getRight());

        Node to = new Node(from);

        to.setLeft(from.getLeft());
        from.setLeft(to);

        if (from.getRight() != null) {
            to.setRight(from.getRight().getLeft());
        }
    }

}

class BST {
    @Getter
    private Node head;

    public void connect(int src, int dst) {
        Node srcNode = find (head, src);
        Node dstNode = find (head, dst);

        if (srcNode != null && dstNode != null) {
            srcNode.setRandom(dstNode);
        }
    }

    private Node find(Node node, int val) {
        if (node == null) {
            return null;
        }

        if (node.getValue() == val) {
            return node;
        } else if (node.getValue() > val) {
            return find(node.getLeft(), val);
        } else if (node.getValue() < val){
            return find(node.getRight(), val);
        }

        return null;
    }

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
            System.out.print("duplicate val " + val);
        }

    }


    public void print() {
        BST.print(head);
    }

    public static void print(Node node) {
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
        if (node.getRandom() != null) {
            System.out.print(node.getRandom().getValue());
        }
        System.out.println();

        print(node.getLeft());
        print(node.getRight());
    }

}

class Node{
    @Getter @Setter
    private Node left, right, random;

    @Getter @Setter
    private Integer value;

    public Node(int val) {
        this.value = val;
    }

    public Node(Node node) {
        this.value = node.getValue();
    }
}