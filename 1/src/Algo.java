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

//    private Integer[] A = {100};
//    private Integer[] A = {100,150};
//    private Integer[] A = {100,90};


    public void run() {
        BST bst = new BST();
        for (Integer ele : A) {
            bst.insert(ele);
        }

        bst.print();
        Integer deleteValue = 90;
        System.out.println("deleting " + deleteValue);
        bst.delete(deleteValue);
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
            replacementNode = findMaxIn(target.getLeft());
            delete(replacementNode.getValue());

            replacementNode.setLeft(target.getLeft());
            replacementNode.setRight(target.getRight());

            dropInReplacement(removalContext, replacementNode);

        } else if (noChildren(target)) {
            dropInReplacement(removalContext, null);
        } else {
            replacementNode = (target.getLeft() == null) ? (target.getRight()) : (target.getLeft());
            dropInReplacement(removalContext, replacementNode);
        }
    }

    private boolean noChildren(Node node) {
        return (node.getLeft() == null) && (node.getRight() == null);
    }

    private boolean bothChildren(Node node) {
        return (node.getLeft() != null) && (node.getRight() != null);
    }

    private Node findMaxIn(Node node) {
        if (node.getRight() == null) {
            return node;
        } else {
            return findMaxIn(node.getRight());
        }
    }

    private RemovalContext makeRemovalContext(Node node, Node parent, Integer value) {
        if (node == null) {
            System.out.print("makeRemovalContext cant find node with " + value);
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
        if(head == null) {
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
            System.out.print("dudde why the fuck are you sending in duplicates?");
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

    @Override
    public boolean equals(Object object) {
        boolean result = false;

        if (object != null && object instanceof Node) {
            Node other = (Node) object;
            result = other.getValue() == value;
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