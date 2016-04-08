/**
 * @author shashaku on 29/03/16.
 */
public class Algo {
//    private Integer[] A = {100,
//            90, 150,
//    70,95,
//    50, 71,
//    40,55,80,
//    30,45,72,
//            75};

    private Integer[] A = {100,
    90, 150,
    70,95, 140,200,
    190,300, 175,400,
    350};

//    private Integer[] A = {100};
//    private Integer[] A = {100,150};
//    private Integer[] A = {100,90};


    public void run() {

        BST bst = new BST(4);
        for (Integer ele : A) {
            System.out.println("\n\nAfter inserting " + ele);
            bst.insert(ele);
            bst.print();
        }


//        Integer deleteNode = 80;
//        bst.delete(deleteNode);
//        System.out.println("deleting " + deleteNode );
//        bst.print();

    }
}

class BST {
    private Node head, minParent;
    private Integer size;

    public BST(Integer size) {
        this.size = size;
        this.minParent = null;
    }

    public void insert(Integer value) {
        if (head == null) {
            head = new Node(value);
        } else {
            insert(head, value);
        }
        updateMinParent(head);

        --size;
        if (size == 0) {
            removeMinimum();
        }

        if (size < 0){
            System.out.println("size < 0");
        }
    }

    private void removeMinimum() {
        if (minParent == null) {
            System.out.println("removing " + head.getValue());
            if (head.getRight() == null) {
                head = null;
            } else {
                head = head.getRight();
            }
        } else {
            System.out.println("removing " + minParent.getLeft().getValue());
            Node minReplacementNode = minParent.getLeft().getRight();
            minParent.setLeft(minReplacementNode);
        }
        ++size;

        updateMinParent(head);
    }

    private void updateMinParent(Node node) {
        if (node == null || node.getLeft() == null) {
            minParent = null;
        }

        if (node.getLeft() != null && node.getLeft().getLeft() != null) {
            updateMinParent(node.getLeft());
        } else if (node.getLeft() != null && node.getLeft().getLeft() == null) {
            minParent = node;
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
            System.out.println("duplicate node insertion ASSHOEL");
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
    private Node left, right;
    private Integer value;

    public Node(Integer value) {
        this.value = value;
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

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}