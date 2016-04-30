public class BinaryCode {


    private Integer[] A = {7, 10, 4, 3, 20, 15};
    private Integer k = 5;

    public void run() {

        BST bst = new BST(k);
        for (Integer ele : A) {
            bst.insert(ele);
            System.out.println(bst.getMax());
        }

        System.out.print(bst.getMax());
    }
}

class BST {
    private Node head, maxParent;
    private Integer size;

    public BST(Integer size) {
        this.size = size;
    }

    public void insert(Integer value) {
        if (head == null) {
            head = new Node(value);
        } else {
            if (getMax() < value && size == 0) {
                return;
            }

            insert(head, value);
        }

        updateMaxParent(head);

        --size;
        if (size < 0) {
            removeMax();
            updateMaxParent(head);
            ++size;
        }
    }

    private void removeMax() {
        if (maxParent == null) {
            head = head.getLeft();
        } else {
            maxParent.setRight(maxParent.getRight().getLeft());
        }
    }

    private void updateMaxParent(Node node) {
        maxParent = null;
        while (node != null && node.getRight() != null) {
            maxParent = node;
            node = node.getRight();
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
            System.out.print("duplicate values " + value);
        }
    }

    public Integer getMax() {
        if (maxParent == null) {
            return head.getValue();
        } else {
            return maxParent.getRight().getValue();
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