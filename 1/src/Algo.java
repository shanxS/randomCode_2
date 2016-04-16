import java.util.ArrayDeque;

public class Algo {

    private Integer[] A = {100,50,150,25,70,110,200,60,75, 190, 250, 55, 65};

    public void run() {
        BinaryTree binaryTree = new BinaryTree();
        for (Integer ele : A) {
            binaryTree.insert(ele);
        }
        binaryTree.print();
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