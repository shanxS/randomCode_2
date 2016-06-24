import lombok.*;

public class Main {
    public static void main(String[] args) {
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

        BST.print(tree.getHead());

        System.out.print("------------");
        NodeDeleter nd = new NodeDeleter();
        Node head = nd.deleteNode(tree.getHead(), 500);
        BST.print(head);

    }
}

class NodeDeleter {

    public Node deleteNode (Node node, int val) {
        Node head = node;
        NodeContext dContext = makeDeletionContext(null, node, val);
        if (dContext == null) {
            System.out.print("cant find node to detele");
            return head;
        }

        Node dNode = dContext.getTarget();
        NodeContext rContext = null;
        if (dNode.getLeft() == null && dNode.getRight() == null) {
            rContext = null;
        } else if (dNode.getLeft() != null && dNode.getRight() == null) {
            rContext = new NodeContext(null, dNode.getLeft());
        } else if (dNode.getRight() != null) {
            rContext = makeMaxNodeContext(dNode, dNode.getRight());
            deleteNode(rContext.getParent(), rContext.getTarget().getValue());
        }
        dropReplacement(dContext, rContext);

        if (dContext.getParent() == null) {
            return rContext.getTarget();
        } else {
            return head;
        }

    }

    private void dropReplacement(NodeContext dContext, NodeContext rContext) {
        Node dParent = dContext.getParent();
        Node dTarget = dContext.getTarget();

        if (rContext == null) {

            if (dParent != null) {
                if (dParent.getValue() < dTarget.getValue()) {
                    dParent.setRight(null);
                } else {
                    dParent.setLeft(null);
                }
            }
        } else {

            Node rParent = rContext.getParent();
            Node rTarget = rContext.getTarget();

            if ( !(dTarget.getLeft() != null && dTarget.getLeft().getValue() == rTarget.getValue())) {
                rTarget.setLeft(dTarget.getLeft());
                rTarget.setRight(dTarget.getRight());
            }

            if (dParent != null) {
                if (dParent.getValue() < dTarget.getValue()) {
                    dParent.setRight(rTarget);
                } else {
                    dParent.setLeft(rTarget);
                }
            }

        }
    }

    private NodeContext makeMaxNodeContext (Node parent, Node node) {
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
        } else {
            return makeDeletionContext(node, node.getLeft(), val);
        }
    }

    private class NodeContext {
        @Getter
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

    public void insert(int val)  {
        if (head == null) {
            head = new Node (val);
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
        } else if (node.getValue() > val){
            if (node.getLeft() == null) {
                node.setLeft(new Node(val));
            } else {
                insert(node.getLeft(), val);
            }
        } else {
            System.out.print("duplicate vlaue " + val);
        }
    }

    public static void print(Node node) {
        if (node== null) {
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

    @Setter @Getter
    private Node left, right;

    @Setter @Getter
    private Integer value;

    public Node(int val) {
        this.value = val;
    }
}