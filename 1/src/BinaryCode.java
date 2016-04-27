public class BinaryCode {

    private Integer[] A = {1, 2, 3, 4, 4};
    private Integer k = 3;

    public void run() {

        BST bst = new BST();

        Integer counter = 0;
        while (counter <= k && counter < A.length) {
            bst.insert(A[counter]);
            ++counter;
        }

        bst.print();

        while (counter < A.length) {
            bst.delete(A[counter-k-1]);
            bst.insert(A[counter]);
            ++counter;
        }
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

    public void delete (Integer value) {

        RemovalContext removalContext = makeRemovalContext(head, null, value);
        if (removalContext == null) {
            System.out.print("cant find node and you are nuts " + value);
            return;
        }

        Node target = removalContext.target;

        Node replacement = null;
        if (bothChildren(target)) {
            replacement = findBiggest(target.getLeft());
            delete(replacement.getValue());

            replacement.setLeft(target.getLeft());
            replacement.setRight(target.getRight());
        } else if (oneChild(target)) {
            replacement = (target.getLeft() == null) ? (target.getRight()) : (target.getLeft());
        } else if (noChild(target)) {
            replacement = null;
        }

        dropInReplacement(removalContext, replacement);
    }

    private void dropInReplacement(RemovalContext removalContext, Node replacement) {
        if (removalContext.parent != null) {

            Node parent = removalContext.parent;
            if (parent.getValue() < removalContext.target.getValue()) {
                parent.setRight(replacement);
            } else {
                parent.setLeft(replacement);
            }

        } else {
            head = replacement;
        }
    }

    private Node findBiggest(Node node) {
        if (node.getRight() == null) {
            return node;
        } else {
            return findBiggest(node.getRight());
        }
    }

    private boolean noChild(Node target) {
        return (target.getRight() == null) && (target.getLeft() == null);
    }

    private boolean oneChild(Node target) {
        return (target.getLeft() != null) || (target.getRight() != null);
    }

    private boolean bothChildren(Node target) {
        return (target.getRight() != null) && (target.getLeft() != null);
    }

    private RemovalContext makeRemovalContext(Node node, Node parent, Integer value) {
        if (node == null) {
            return null;
        }

        if (node.getValue() > value) {
            return makeRemovalContext(node.getLeft(), node, value);
        } else if (node.getValue() < value) {
            return makeRemovalContext(node.getRight(), node, value);
        }

        return new RemovalContext(parent, node);
    }

    private class RemovalContext {
        public Node parent, target;

        public RemovalContext(Node parent, Node target) {
            this.parent = parent;
            this.target = target;
        }
    }


    public void print() {
        print(head);
    }

    private void print(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.getValue() + " : ");
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
        } else {
            System.out.println("repeated " + value);
        }
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