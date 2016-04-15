public class Algo {

    private Integer[] A = {100,50,150,25,70,110,200,60,75, 190, 250, 55, 65};

    public void run() {
        BST bst = new BST();
        for (Integer ele : A) {
            bst.insert(ele);
        }
        bst.find(70);
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

    public void find(Integer target) {

        traverseInorder(head, target);
    }

    private Node traverseInorder(Node node, Integer target) {
        if (node == null) {
            return node;
        }

        Node pre = traverseInorder(node.getLeft(), target);

        Node post = traverseInorder(node.getRight(), target);

        if (node.getValue() == target) {
            System.out.println((pre == null) ? ("null") : pre.getValue());
            System.out.println((post == null) ? ("null") : post.getValue());
        }


        if (pre == null) {
            return node;
        } else {
            return pre;
        }
    }

    private void insert(Node node, Integer value) {
        if (node.getValue() > value) {
            if (node.getLeft() != null) {
                insert(node.getLeft(), value);
            } else {
                node.setLeft(new Node(value));
            }
        } else if (node.getValue() < value) {
            if (node.getRight() != null) {
                insert(node.getRight(), value);
            } else {
                node.setRight(new Node(value));
            }
        } else {
            System.out.print("wtf");
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

class Node{
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