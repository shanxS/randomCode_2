public class Algo {

    private Integer[] A = {100,50,150,25,70,110,200,60,75};

    public void run() {
        BST bst = new BST();
        for (Integer ele : A) {
            bst.insert(ele);
        }
        bst.printInorder();
    }
}


class BST {
    private Node head;

    public void insert(Integer value) {
        if (head == null) {
            head = new Node(value);
        } else {
            insert(head, value);
        }
    }

    public void printInorder() {
        printInorder(head);
    }

    private void printInorder(Node node) {
        if (node == null) {
            return;
        }

        printInorder(node.getLeft());
        System.out.print(node.getValue() + " ");
        printInorder(node.getRight());
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
            System.out.print("wtf!");
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
        if (node.getLeft() == null) {
            System.out.print(node.getLeft().getValue());
        }
        System.out.print(", ");
        if (node.getRight() == null) {
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