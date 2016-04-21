public class Algo {

    private Integer[] A = {1, 11, 2, 10, 4, 5, 2, 1};

    public void run() {

        BST bst = new BST();
        for (Integer i=A.length-1; i>=0; --i) {
            bst.insert(A[i]);
        }

        bst.print();

        System.out.print(bst.findMaxBitonic());

   }
}

class BST {
    private Node head;

    public void insert(Integer value) {

        if (head == null) {
            head = new Node(value, 0);
        } else {
            insert(value, head, head.getDec());
        }

    }

    public void print() {
        print(head);
    }

    private void print(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.getValue() + " d:" + node.getDec() + " i:" + node.getInc() + " - ");
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

    private void insert(Integer value, Node node, Integer dec) {
        if (node.getValue() < value) {

            Integer maxDec = Math.max(dec, node.getDec());

            if (node.getRight() == null) {
                node.setRight(new Node(value, maxDec));
            } else {

                insert(value, node.getRight(), maxDec);

            }

        } else {

            node.bumpInc();
            bumpRights(node.getRight());

            if (node.getLeft() == null) {
                node.setLeft(new Node(value, dec));
            } else {
                insert(value, node.getLeft(), dec);
            }

        }
    }

    private void bumpRights(Node node) {
        if (node == null) {
            return;
        }

        node.bumpInc();
        bumpRights(node.getLeft());
        bumpRights(node.getRight());
    }


    private Integer maxBitonic;
    public Integer findMaxBitonic() {
        maxBitonic = Integer.MIN_VALUE;
        find(head);

        return maxBitonic;
    }

    private void find(Node node) {
        if (node == null) {
            return;
        }

        maxBitonic = Math.max(maxBitonic, (node.getInc() + node.getDec()));
        find(node.getLeft());
        find(node.getRight());
    }
}

class Node {
    private Integer value;
    private Integer inc;
    private Integer dec;

    private Node left, right;

    public Node(Integer value, Integer dec) {
        this.value = value;
        this.dec = dec + 1;
        this.inc = 0;
    }

    public void bumpInc() {
        ++inc;
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

    public Integer getInc() {
        return inc;
    }

    public Integer getDec() {
        return dec;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}