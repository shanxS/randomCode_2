import java.util.ArrayDeque;

public class Algo {

    private Integer[] A = {100,
    50, 150,
    25, 70, 110, 30,
    10, 200};

    public void run() {
        BinaryTree binaryTree = new BinaryTree();
        for (Integer ele : A) {
            binaryTree.insert(ele);
        }
        binaryTree.print();

        BSTTester tester = new BSTTester();

        System.out.print(tester.test(
                binaryTree.getHead()));
    }
}

class BSTTester {
    private Boolean status;
    public Boolean test(Node head) {
        status = true;
        testInorder(head);

        return status;
    }

    private Node testInorder(Node node) {
        if (node == null || !status) {
            return null;
        }

        Node pre = testInorder(node.getLeft());
        if (pre != null && pre.getValue() > node.getValue()) {
            status = false;
            return null;
        }

        Node post = testInorder(node.getRight());
        if (post != null && post.getValue() < node.getValue()) {
            status = false;
            return null;
        }

        return (post == null) ? node : post;
    }
}


class BinaryTree {
    private Node head;
    private ArrayDeque<Node> parents;

    public BinaryTree() {
        parents = new ArrayDeque<>();
    }


    public void insert(Integer value) {
        Node node = new Node(value);

        if (head == null) {
            head = node;
        } else {
            while (parents.size() > 0) {
                Node thisParent = parents.peekFirst();
                if (thisParent.getLeft() != null && thisParent.getRight() != null) {
                    parents.removeFirst();
                } else if (thisParent.getLeft() == null) {
                    thisParent.setLeft(node);

                    break;
                } else if (thisParent.getRight() == null) {
                    thisParent.setRight(node);

                    break;
                }
            }
        }

        parents.addLast(node);
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

    public Node getHead() {
        return head;
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

    public Integer getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}