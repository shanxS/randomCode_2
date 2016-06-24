import lombok.*;

public class Main {
    public static void main(String [] args) {
        Algo algo = new Algo();
        algo.run();
    }
}

class Algo {
    private int[] A = {
            1000,
            700, 1010,
            500,800,1020,
            400,600,900,
            550,850,950,
            530,570,970
    };


    public void run() {

        BST tree = new BST();
        for (Integer i : A) {
            tree.insert(i);
        }

        tree.print();

        System.out.print("------------");
        NodeDeleter nd = new NodeDeleter();
        Node head = nd.delete(tree.getHead(), 1000);
        BST.print(head);

    }
}

class NodeDeleter {

    public Node delete(Node node, int val) {
        Node head = node;
        NodeContext deleteContext = makeDeletionContext(null, node, val);
        if (deleteContext == null) {
            System.out.print("cant find node to delete");
            return head;
        }

        Node deleteTarget = deleteContext.getTarget();
        NodeContext replacementContext = null;

        if (deleteTarget.getLeft() == null && deleteTarget.getRight() == null ) {

            dropReplacement(deleteContext, null);

        } else if (deleteTarget.getLeft() != null && deleteTarget.getRight() == null) {

            replacementContext = new NodeContext(null, deleteTarget.getLeft());
            //delete(deleteTarget, deleteTarget.getLeft().getValue());
            dropReplacement(deleteContext, replacementContext);

        } else if (deleteTarget.getRight() != null) {

            replacementContext = makeMaxNodeContext (null, deleteTarget.getRight());

            Node deletionTreeHead = (replacementContext.getParent() == null) ?  deleteTarget : replacementContext.getParent();
            delete(deletionTreeHead, replacementContext.getTarget().getValue());

            dropReplacement(deleteContext, replacementContext);

        }

        if (deleteContext.getParent() == null) {
            if (replacementContext == null) {
                return null;
            } else {
                return replacementContext.getTarget();
            }
        } else {
            return head;
        }
    }

    private void dropReplacement(NodeContext deleteContext, NodeContext replacementContext) {
        if (deleteContext.getParent() == null ){
            if (replacementContext != null) {
                Node replacement = replacementContext.getTarget();
                replacement.setRight(deleteContext.getTarget().getRight());
                replacement.setLeft(deleteContext.getTarget().getLeft());
            }
        } else {
            Node dParent = deleteContext.getParent();
            Node dTarget = deleteContext.getTarget();

            if (replacementContext == null) {

                if (dParent.getValue() > dTarget.getValue()) {
                    dParent.setLeft(null);
                } else {
                    dParent.setRight(null);
                }

            } else {

                Node rTarget = replacementContext.getTarget();

                if (! (dTarget.getLeft() != null && dTarget.getLeft().getValue() == rTarget.getValue())) {

                    rTarget.setRight(dTarget.getRight());
                    rTarget.setLeft(dTarget.getLeft());

                }


                if (dParent.getValue() > dTarget.getValue()) {
                    dParent.setLeft(rTarget);
                } else {
                    dParent.setRight(rTarget);
                }

            }
        }
    }

    private NodeContext makeMaxNodeContext(Node parent, Node node) {
        while (node.getRight() != null) {
            parent = node;
            node = node.getRight();
        }

        return new NodeContext(parent, node);
    }

    private NodeContext makeDeletionContext(Node parent, Node node, int val) {
        if (node == null) {
            return null;
        }

        if (node.getValue() == val) {
            return new NodeContext(parent, node);
        } else if (node.getValue() < val) {
            return makeDeletionContext(node, node.getRight(), val);
        } else if (node.getValue() > val) {
            return makeDeletionContext(node, node.getLeft(), val);
        }

        return null;
    }

    private class NodeContext {
        @Getter @Setter
        private Node parent, target;

        public NodeContext(Node parent, Node target) {
            this.parent = parent;
            this.target = target;
        }

    }
}

class BST {
    @Getter
    private Node head;

    public void insert(int val) {
        if (head == null) {
            head = new Node(val);
        } else {
            insert(head, val);
        }
    }

    private void insert(Node node, int val) {

        if (node.getValue() < val) {
            if (node.getRight() == null) {
                node.setRight(new Node(val));
            } else {
                insert(node.getRight(), val);
            }
        } else if (node.getValue() > val) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(val));
            } else {
                insert(node.getLeft(), val);
            }
        } else {
            System.out.print("duplicate value " + val);
        }
    }

    public void print() {
        BST.print(head);
    }

    public static void print(Node node) {
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
    @Getter @Setter
    private Node left, right;

    @Getter @Setter
    private Integer value;


    public Node(int val) {
        this.value = val;
    }

}