public class Algo {

    private Integer[] A = {2900,2500,3000,1500,700,800,2000,1000,500};

    public void run() {

        BST bst = new BST();
        for (Integer i=A.length-1; i>=0; --i) {
            Integer ele = A[i];
            bst.insert(ele);
        }

        bst.print();

    }
}

class BST {
    private Node head;

    public void insert(Integer value) {
        if (head == null) {
            head = new Node(value, 0);
        } else {
            insert(head, value, 0);
        }
    }

    private void insert(Node node, Integer value, Integer inherit) {

         if (node.getValue() > value) {

             if (node.getLeft() == null) {
                 node.setLeft(new Node(value, inherit));
             } else {
                 insert(node.getLeft(), value, inherit);
             }

             node.bumpAfterLess();
         } else if (node.getValue() < value) {

             inherit += (1 + node.getAfterLess());

             if (node.getRight() == null) {
                 node.setRight(new Node(value, inherit));
             } else {
                 insert(node.getRight(), value, inherit);
             }

         }

    }

    public void print() {
        print(head);
    }

    private void print(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.getValue() + " (" + node.getBeforeLess() + ") " + " - ");
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
    private Integer value, beforeLess, afterLess;

    public Node(Integer value, Integer beforeLess) {
        this.value = value;
        this.beforeLess = beforeLess;
        this.afterLess = 0;
    }

    public void bumpAfterLess() {
        ++afterLess;
    }

    public Integer getAfterLess() {
        return afterLess;
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

    public Integer getBeforeLess() {
        return beforeLess;
    }
}