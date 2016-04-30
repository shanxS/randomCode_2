public class BinaryCode {


    private Integer[] A = {7, 10, 4, 3, 20, 15};
    private Integer k = 3;

    public void run() {

        BST bst = new BST(k);
        for (Integer ele : A) {
            bst.insert(ele);

        }

        System.out.print(bst.getMin());
    }
}

class BST {
    private Node head;
    private Node minHead;
    private Integer size;

    public BST(Integer size) {
        this.size = size;
    }

    public Integer getMin () {
        if (minHead == null) {
            return head.getValue();
        } else {
            return minHead.getLeft().getValue();
        }
    }

    public void insert(Integer value) {
        if (head == null) {
            head = new Node(value);
        } else {

            if (value < getMin()) {
                return;
            }

            insert(head, value);
        }

        --size;
        if (size < 0) {
            removeMin();
            ++size;
        }
        updateMinHead(head);
    }

    private void updateMinHead(Node node) {

        minHead = null;
        while (node.getLeft() != null) {
            minHead = node;
            node = node.getLeft();
        }

    }

    private void removeMin() {
        if (minHead == null) {
            head = head.getRight();
        } else {
            minHead.setLeft(null);
        }
    }

    public void insert(Node node, Integer value) {
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
            System.out.print("duplicate values " + value);
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