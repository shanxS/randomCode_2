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

        Integer deleteNode = 95;
        System.out.println(" deleting  " + deleteNode);
        bst.delete(deleteNode);
        bst.print();
    }
}

class BST {
    private Node head;

    public void delete(Integer value) {
        RemovalContext removalContext = getRemovalContext(head, null, value);
        System.out.println("deleting for " + removalContext.toString());

        Node replacementNode;
        if (bothChildrenExist(removalContext.getTarget())) {
            replacementNode = findMaxIn (removalContext.getTarget().getLeft());
            delete(replacementNode.getValue());

            replacementNode.setLeft(removalContext.getTarget().getLeft());
            replacementNode.setRight(removalContext.getTarget().getRight());

            dropInReplacement(removalContext, replacementNode);

        } else if (noChildExist(removalContext.getTarget())) {

            dropInReplacement(removalContext, null);

        } else {
            if (removalContext.getTarget().getLeft() != null) {
                replacementNode = removalContext.getTarget().getLeft();
                //delete(replacementNode.getValue());
                //removalContext.getTarget().setLeft(null);

            } else {
                replacementNode = removalContext.getTarget().getRight();

            }

            dropInReplacement(removalContext, replacementNode);
        }
    }

    private void dropInReplacement(RemovalContext removalContext, Node replacement) {

        if (removalContext.getTargetParent() != null) {
            if (removalContext.getTargetParent().getLeft() != null && removalContext.getTargetParent().getLeft().equals(removalContext.getTarget())) {
                removalContext.getTargetParent().setLeft(replacement);
            } else {
                removalContext.getTargetParent().setRight(replacement);
            }
        } else {
            head = replacement;
        }
    }

    private Node findMaxIn(Node node) {
        if (node.getRight() == null) {
            return node;
        } else {
            return findMaxIn(node.getRight());
        }
    }

    private boolean noChildExist(Node node) {
        return (node.getLeft() == null) && (node.getRight() == null);
    }

    private boolean bothChildrenExist(Node node) {
        return (node.getLeft() != null) && (node.getRight() != null);
    }

    private RemovalContext getRemovalContext(Node node, Node parent, Integer value) {
        if (node == null) {
            System.out.print("getRemoveContext cant find " + value);
            return null;
        }

        if (node.getValue() < value) {
            return getRemovalContext(node.getRight(), node, value);
        } else if (node.getValue() > value) {
            return getRemovalContext(node.getLeft(), node, value);
        } else {
            return new RemovalContext(node, parent);
        }
    }

    private class RemovalContext {
        private Node target, targetParent;

        public RemovalContext(Node target, Node targetParent) {
            this.target = target;
            this.targetParent = targetParent;
        }

        @Override
        public String toString() {
            return ""
                    + (target == null ? ("null") : target.getValue())
                    + " "
                    + (targetParent == null ? ("null") : targetParent.getValue());
        }

        public Node getTarget() {
            return target;
        }

        public Node getTargetParent() {
            return targetParent;
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

    public Node(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;

        if (object != null && object instanceof Node) {
            Node other = (Node) object;
            if (other.value == value) {
                result = true;
            }
        }

        return result;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int hash = 7;
        hash = (hash*prime) + (value.hashCode());
        return hash;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
