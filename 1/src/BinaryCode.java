import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class BinaryCode {

    private Integer[] A = {2, 5, 2, 8, 5, 6, 8, 8};
    private Map<Integer, BST> freqSeq;

    public void run() {

        BST bst = makeBST();
        scanBST(bst);
        printResult();


    }

    private void printResult() {
        for (Integer i=1; i<A.length; ++i) {

            if (freqSeq.get(i) != null) {
                freqSeq.get(i).printInSeq(i);
            }

        }
    }

    private void scanBST(BST bst) {
        Node head = bst.getHead();
        freqSeq = new HashMap<>();

        scan(head);

    }

    private void scan(Node node) {
        if (node == null) {
            return;
        }

        BST fBST = freqSeq.get(node.getFreq());
        if (fBST == null) {
            fBST = new BST(new PositionComparator());
            freqSeq.put(node.getFreq(), fBST);
        }
        fBST.insert(node.getValue(), node.getPosition());

        scan(node.getLeft());
        scan(node.getRight());
    }

    private BST makeBST() {
        BST bst = new BST(new GeneralComparator());
        for (Integer i=0; i<A.length; ++i) {
            bst.insert(A[i], i);
        }

        return bst;
    }
}

class BST {
    private Node head;
    private final Comparator<Node> comparator;

    public BST(Comparator<Node> comparator) {
        this.comparator = comparator;
    }

    public void insert(Integer value, Integer pos) {
        if (head == null) {
            head = new Node(value, pos);
        } else {
            insert(head, new Node(value, pos));
        }
    }

    private void insert(Node node, Node newNode) {
        if (comparator.compare(node, newNode) < 0) {
            if (node.getRight() == null) {
                node.setRight(newNode);
            } else {
                insert(node.getRight(), newNode);
            }
        } else if (comparator.compare(node, newNode) > 0) {
            if (node.getLeft() == null) {
                node.setLeft(newNode);
            } else {
                insert(node.getLeft(), newNode);
            }
        } else {
            node.bumpFreq();
        }
    }

    public void printInSeq(Integer thisFreq) {
        printInSeq(head, thisFreq);
    }

    private void printInSeq(Node node, Integer thisFreq) {
        if (node == null) {
            return;
        }

        printInSeq(node.getLeft(), thisFreq);
        for (Integer i=0; i<thisFreq; ++i) {
            System.out.print(node.getValue() + " ");
        }
        printInSeq(node.getRight(), thisFreq);
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

    public Node getHead() {
        return head;
    }
}

class PositionComparator implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        if (o1.getPosition() == o2.getPosition()) {
            return 0;
        } else if (o1.getPosition() < o2.getPosition()) {
            return -1;
        } else {
            return 1;
        }
    }
}

class GeneralComparator implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        if (o1.getValue() == o2.getValue()) {
            return 0;
        } else if (o1.getValue() < o2.getValue()) {
            return -1;
        } else {
            return 1;
        }
    }
}

class Node {
    private Node left, right;
    private Integer value, position, freq;

    public Node(Integer value, Integer position) {
        this.value = value;
        this.position = position;
        this.freq = 1;
    }

    public void bumpFreq() {
        ++freq;
    }

    public Integer getFreq() {
        return freq;
    }

    public Integer getPosition() {
        return position;
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