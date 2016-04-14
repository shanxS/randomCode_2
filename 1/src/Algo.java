import java.util.ArrayDeque;

public class Algo {

    private Integer[] A = {1, 2, 30, 4, 5, 6};
    public void run() {
        BST bst = new BST(3);
        for (Integer ele : A) {
            bst.insert(ele);
            bst.printBiggest();
        }
    }
}

class BST {
    private Node head;

    private ArrayDeque<Integer> deletionStack;
    private final Integer size;

    public BST(Integer size) {
        this.size = size;
        deletionStack = new ArrayDeque<>();
    }


    public void printBiggest() {
        System.out.println(getBiggestNode(head).getValue());
    }


    public void insert(Integer value) {
        if (head == null) {
            head = new Node(value);
        } else {
            insert(head, value);
        }

        pushDeletionContext(value);

        if (size < deletionStack.size()) {
            deleteNode(deletionStack.removeLast());
        }
    }

    private void deleteNode(Integer value) {
        DeletionContext deletionContext = makeDeletionContext(value, head, null);

        Node target = deletionContext.target;
        Node replacementNode;
        if (bothChildren(target)) {
            replacementNode = getBiggestNode(target.getRight());
            deleteNode(replacementNode.getValue());

            replacementNode.setRight(target.getRight());
            replacementNode.setLeft(target.getLeft());

        } else if (oneChild (target)) {
            replacementNode = (target.getLeft() == null) ? target.getRight() : target.getLeft();
        } else {
            replacementNode = null;
        }

        dropInReplacement(deletionContext, replacementNode);
    }

    private boolean oneChild(Node target) {
        return (target.getRight() != null) || (target.getLeft() != null);
    }

    private boolean bothChildren(Node target) {
        return (target.getRight() != null) && (target.getLeft() != null);
    }

    private Node getBiggestNode(Node node) {
        if (node.getRight() == null) {
            return node;
        } else {
            return getBiggestNode(node.getRight());
        }
    }

    private void dropInReplacement(DeletionContext deletionContext, Node replacementNode) {
        Node parent = deletionContext.parent;
        Node target = deletionContext.target;

        if (parent != null) {
            if (parent.getValue() > target.getValue()) {
                parent.setLeft(replacementNode);
            } else {
                parent.setRight(replacementNode);
            }
        } else {
            head = replacementNode;
        }

    }

    private DeletionContext makeDeletionContext(Integer value, Node node, Node parent) {
        if (node == null) {
            System.out.print("cant find node " + value);
        }

        if (node.getValue() == value) {
            return new DeletionContext(parent, node);
        } else if (node.getValue() > value) {
            return makeDeletionContext(value, node.getLeft(), node);
        } else
            return makeDeletionContext(value, node.getRight(), node);
        }


    class DeletionContext {
        private Node parent;
        private Node target;

        public DeletionContext(Node parent, Node target) {
            this.target = target;
            this.parent = parent;
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

    private void pushDeletionContext(Integer value) {
        deletionStack.addFirst(value);
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
    private Integer value;
    private Node left, right;

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
