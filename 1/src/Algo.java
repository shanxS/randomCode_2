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

//    private Integer[] A = {100};
//    private Integer[] A = {100,150};
//    private Integer[] A = {100,90};


    public void run() {

        BST bst = new BST();
        for (Integer ele : A) {
            bst.insert(ele);
        }

        bst.print();
        Integer deleteNode = 80;
        bst.delete(deleteNode);
        System.out.println("deleting " + deleteNode );
        bst.print();

    }
}

class BST {
    private Node head;

    public void delete(Integer value) {
        RemovalContext removalContext = makeRemovalContext(head, null, value);

        Node target = removalContext.target;
        Node replacementNode;
        if (bothChildren(target)) {
            replacementNode = getMaxIn(target.getLeft());
            delete(replacementNode.getValue());

            replacementNode.setRight(target.getRight());
            replacementNode.setLeft(target.getLeft());

        } else if (noChild(target)) {
            replacementNode = null;
        } else {
            replacementNode = (target.getLeft() != null) ? target.getLeft() : target.getRight();
        }

        dropInReplacement(removalContext, replacementNode);
    }

    private boolean noChild(Node node) {
        return (node.getLeft() == null) && (node.getRight() == null);
    }

    private Node getMaxIn(Node node) {
        if (node.getRight() != null) {
            return getMaxIn(node.getRight());
        } else {
            return node;
        }
    }

    private boolean bothChildren(Node node) {
        return (node.getLeft() != null) && (node.getRight() != null);
    }

    private RemovalContext makeRemovalContext(Node node, Node parent, Integer value) {
        if (node == null) {
            sprint("cant find node for remocalContext " + value);
        }

        if (node.getValue() > value) {
            return makeRemovalContext(node.getLeft(), node, value);
        } else if (node.getValue() < value) {
            return makeRemovalContext(node.getRight(), node, value);
        } else {
            return new RemovalContext(node, parent);
        }
    }

    private void dropInReplacement(RemovalContext removalContext, Node replacementNode) {
        Node target = removalContext.target;
        Node targetParent = removalContext.targetParent;

        if (targetParent != null) {
            if (targetParent.getLeft() != null && targetParent.getLeft().equals(target)) {
                targetParent.setLeft(replacementNode);
            } else {
                targetParent.setRight(replacementNode);
            }
        } else {
            head = replacementNode;
        }
    }

    private class RemovalContext {
        private final Node target, targetParent;

        public RemovalContext(Node target, Node targetParent) {
            this.target = target;
            this.targetParent = targetParent;
        }
    }

    public void insert(Integer value) {
        if (head == null) {
            head = new Node(value);
        } else {
            insert(head, value);
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
        } else {
            System.out.print("dude wtf!");
        }
    }

    public void print() {
        print(head);
    }

    private void print(Node node) {
        if (node == null) {
            return;
        }

        sprint(node.getValue() + " - ");
        if (node.getLeft() != null) {
            sprint(node.getLeft().getValue());
        }
        sprint(", ");
        if (node.getRight() != null) {
            sprint(node.getRight().getValue());
        }
        sprint("\n");

        print(node.getLeft());
        print(node.getRight());
    }

    private void sprint (Object o) {
        System.out.print(o);
    }
}


class Node {
    private Node left, right;
    private Integer value;


    public Node (Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;

        if (object != null && object instanceof Node) {
            Node other = (Node) object;
            result = other.value == value;
        }

        return result;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 7;
        result = (result*prime) + value.hashCode();


        return result;
    }

    public void setValue(Integer value) {
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