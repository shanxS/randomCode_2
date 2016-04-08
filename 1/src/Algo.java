/**
 * @author shashaku on 29/03/16.
 */
public class Algo {
    private Integer[] A = {100,
            90, 150,
    70,95,
    50, 71,
    40,55,80,
    30,45,72,
            75};

//    private Integer[] A = {100,
//    90, 150,
//    70,95, 140,200,
//    190,300, 175,400,
//    350,10};


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

    private Node head, maxNodeParent;
    private Integer size;

    public BST(Integer size) {
        this.size = size;
        this.maxNodeParent = null;
        this.head = null;
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

    public void insert(Integer value) {
        if (size == 0 && getMaxValue() < value ) {
            System.out.println("why bother adding " + value);
            return;
        }

        if (head == null) {
            head = new Node(value);
        } else {
            insert(head, value);
        }
        --size;
        updateMaxNodeParent(head);

        if (size < 0) {
            deleteMaxNode();
            updateMaxNodeParent(head);
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
        }
    }

    private void updateMaxNodeParent(Node node) {
        if (node == null || node.getRight() == null) {
            maxNodeParent = null;
        } else if (node.getRight() != null && node.getRight().getRight() == null) {
            maxNodeParent = node;
        } else if (node.getRight() != null && node.getRight().getRight() != null) {
            updateMaxNodeParent(node.getRight());
        }
    }

    private void deleteMaxNode() {
        if (maxNodeParent == null) {
            System.out.println("deleting node " + getMaxValue());
            if (head.getLeft() == null) {
                head = null;
            } else {
                head = head.getLeft();
            }
        } else {
            System.out.println("deleting node " + getMaxValue());
            Node replacementNode = maxNodeParent.getRight().getLeft();
            maxNodeParent.setRight(replacementNode);
        }

        ++size;
    }

    private Integer getMaxValue() {
        if (maxNodeParent == null) {
            return head.getValue();
        } else {
            return maxNodeParent.getRight().getValue();
        }
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