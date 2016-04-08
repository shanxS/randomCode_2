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
    350,10};

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

    public BST(Integer size) {
        this.size = size;
        this.minParent = null;
        this.head = null;
    }

    public void insert(Integer value) {
        if (size == 0 && getMinValue() > value) {
            System.out.println("why bother adding " + value);
            return;
        }


        if (head == null) {
            head = new Node(value);
        } else {
            insert(head, value);
        }
        --size;
        updateMinParentNode(head);

        if (size < 0) {
            removeMinNode();
            updateMinParentNode(head);
        }
    }

    private Integer getMinValue() {
        if (minParent == null) {
            return head.getValue();
        } else {
            return minParent.getLeft().getValue();
        }
    }

    private void insert(Node node, Integer value) {
        if (node.getValue() < value) {
            if (node.getRight() == null) {
                node.setRight(new Node(value));
            } else {
                insert(node.getRight(), value);
            }
        } else if (node.getValue() > value) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(value));
            } else {
                insert(node.getLeft(), value);
            }
        }
    }

    private void removeMinNode() {
        if (minParent == null) {
            System.out.println("removing " + head.getValue());
            if (head.getRight() == null) {
                head = null;
            } else {
                head = head.getRight();
            }
        } else {
            System.out.println("removing " + minParent.getLeft().getValue());
            Node replacementNode = minParent.getLeft().getRight();
            minParent.setLeft(replacementNode);
        }

        ++size;
    }

    private void updateMinParentNode(Node node) {
        if (node == null || node.getLeft() == null) {
            minParent = null;
        } else if (node.getLeft() != null && node.getLeft().getLeft() == null) {
            minParent = node;
        } else {
            updateMinParentNode(node.getLeft());
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