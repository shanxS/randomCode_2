public class BinaryCode {

    private Integer[] A = {6, 7, 8, 1, 2, 3, 9, 10};
    Integer[] maxL = new Integer[A.length];
    Integer[] maxR = new Integer[A.length];

    public void run() {

        BST bst = new BST();
        for (Integer i=0; i<A.length; ++i) {
            maxL[i] = bst.insert(A[i]);
        }

        for (Integer i=A.length-2; i>=0; --i) {
            if (i+1 == A.length-1) {
                maxR[i] = A[i+1];
            } else {
                maxR[i] = Math.max(maxR[i+1], A[i+1]);
            }
        }

        Integer[] values = new Integer[3];
        Integer maxProd = Integer.MIN_VALUE;
        for (Integer i=1; i<A.length-1; ++i) {
            Integer biggestLeft = maxL[i];
            Integer biggestRight = (maxR[i] < A[i]) ? null : maxR[i];

            if (biggestLeft != null
                    && biggestRight != null
                    && maxProd < (biggestLeft * biggestRight * A[i])) {
                maxProd = (biggestLeft * biggestRight * A[i]);
                values[0] = biggestLeft;
                values[1] = A[i];
                values[2] = biggestRight;
            }

        }

        System.out.println(maxProd);
        for (Integer ele : values) {
            System.out.print(ele + " ");
        }
    }
}

class BST {
    private Node head;

    public Integer insert(Integer value) {
        Node node = new Node(value);

        if (head == null) {
            head = node;
        } else {
            insert(head, node);
        }

        return node.getBiggestSmallValue();
    }

    private void insert(Node parent, Node child) {
        if (parent.getValue() > child.getValue()) {
            if (parent.getLeft() == null) {
                parent.setLeft(child);
            } else {
                insert(parent.getLeft(), child);
            }
        } else if (parent.getValue() < child.getValue()) {
            child.setBiggestSmallValue(parent.getValue());

            if (parent.getRight() == null) {
                parent.setRight(child);
            } else {
                insert(parent.getRight(), child);
            }
        }
    }
}

class Node {
    private Node left, right;
    private Integer value, biggestSmallValue;

    public Integer getBiggestSmallValue() {
        return biggestSmallValue;
    }

    public void setBiggestSmallValue(Integer biggestSmallValue) {
        this.biggestSmallValue = biggestSmallValue;
    }

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