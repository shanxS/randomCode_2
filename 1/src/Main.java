import lombok.*;

public class Main {
    public static void main(String[] arg) {
        Algo algo = new Algo();
        algo.run();
    }
}

class Algo {
    private int[] A = {90, 50, 100, 40, 75, 95, 110, 65, 85};

    public void run() {
        BST tree = new BST();
        for (Integer i : A) {
            tree.insert(i);
        }

        tree.print();

        NodeDeleter nd = new NodeDeleter();
        Node newHead = nd.delete(tree.getHead(), 90);
        System.out.println("----------");
        BST.print(newHead);
    }
}

class NodeDeleter {
    public Node delete(Node head, int value) {
        NodeContext deleteContext = makeDeleteContext(head, null, value);
        if (deleteContext == null) {
            System.out.print("cant find node to delte " + value);
            return head;
        }

        Node replacement = null;
        Node target = deleteContext.getTarget();
        if (target.getRight() != null) {
            Node maxRightChild = getMaxNode (target.getRight());
            delete(target, maxRightChild.getValue());

            maxRightChild.setRight(target.getRight());
            maxRightChild.setLeft(target.getLeft());

            replacement = maxRightChild;
        } else if (target.getLeft() != null) {
            replacement = target.getLeft();
        } else {
            // if no child - do nothing
        }

        dropReplacement(deleteContext, replacement);

        return (deleteContext.getParent() == null) ? replacement : head;
    }

    private Node getMaxNode(Node node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }

    private NodeContext makeDeleteContext(Node node, Node parent, int value) {
        if (node == null) {
            return null;
        }

        if (node.getValue() == value) {
            return new NodeContext(node, parent);
        } else if (node.getValue() < value) {
            return makeDeleteContext(node.getRight(), node, value);
        } else {
            return makeDeleteContext(node.getLeft(), node, value);
        }
    }

    private void dropReplacement(NodeContext context, Node replacement) {

        if (context.getParent() != null) {

            Node parent = context.getParent();
            Node target = context.getTarget();

            if (parent.getLeft() != null && parent.getLeft().getValue() == target.getValue()) {
                parent.setLeft(replacement);
            } else {
                parent.setRight(replacement);
            }

        }
    }

    private class NodeContext {
        @Getter @Setter
        private Node target, parent;

        public NodeContext(Node target, Node parent) {
            this.target = target;
            this.parent = parent;
        }
    }
}

class BST {
    @Getter
    private Node head;

    public void insert(int value) {
        if (head == null) {
            head = new Node(value);
        } else {
            insert(head, value);
        }
    }

    private void insert(Node node, int value) {
        if (node.getValue() < value) {
            if (node.getRight() == null) {
                node.setRight(new Node(value));
            } else {
                insert(node.getRight(), value);
            }
        } else if (node.getValue() > value) {
            if (node.getLeft() == null ) {
                node.setLeft(new Node(value));
            } else {
                insert(node.getLeft(), value);
            }
        } else {
            System.out.print("duplicate " + value);
        }
    }

    public void print() {
        BST.print(head);
    }

    public static void print(Node node) {
        if (node == null) {
            return;
        }


        System.out.print(node.getValue() + " | ");
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
    @Setter @Getter
    private int value;

    @Setter @Getter
    private Node left, right;

    public Node (int v) {
        this.value = v;
    }
}