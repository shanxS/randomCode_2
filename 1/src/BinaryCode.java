import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryCode {

    private int[] A = {10,2,7,8,4};

    public void run() {

        BT bt = new BT();

        for (Integer ele : A) {
            bt.insert(ele);
        }

        bt.print();
        System.out.println("----------");
        bt.convert();
        bt.print();
        System.out.println("----------");

   }

}

class Convertor {

    private List<Integer> numbers;

    public void convertToBST(Node head) {

        numbers = new ArrayList<>();
        traverse(head);
        sort(0, numbers.size()-1);
        inorderReplacement(head, 0);

    }

    private int inorderReplacement(Node node, int pos) {

        if (node == null) {
            return pos;
        }

        pos = inorderReplacement(node.getLeft(), pos);

        node.setValue(numbers.get(pos));
        ++pos;

        return  inorderReplacement(node.getRight(), pos);
    }

    private void sort(int start, int end) {

        if (start >= end) {
            return;
        }

        Integer pivot = qSort(start, end);
        sort(start, pivot-1);
        sort(pivot+1, end);

    }

    private Integer qSort(int start, int end) {
        Integer marker = start-1;
        Integer pivotValue = numbers.get(end);

        for (Integer i=start; i<end; ++i) {
            if (numbers.get(i) <= pivotValue) {
                ++marker;
                swap (i, marker);
            }
        }

        swap(marker+1, end);
        return marker+1;
    }

    private void swap(int from, int to) {
        Integer tmp = numbers.get(from);
        numbers.set(from, numbers.get(to));
        numbers.set(to, tmp);
    }

    private void traverse(Node node) {
        if (node == null) {
            return;
        }

        numbers.add(node.getValue());
        traverse(node.getLeft());
        traverse(node.getRight());
    }

}

class BT {
    private Node head;
    private ArrayDeque<Node> startD, otherD;


    public void insert(Integer value) {
        if (head == null) {
            head = new Node(value);
        } else {
            insertChildren(value);
        }
    }

    private void insertChildren(Integer value) {
        ArrayDeque<Node> d1;
        if (startD == null) {
            d1 = new ArrayDeque<>();
            d1.addLast(head);
        } else {
            d1 = startD;
        }

        ArrayDeque<Node> d2 = (otherD == null) ? new ArrayDeque<>() : otherD;

        while (true) {

            if (processFor(d1, d2, value)) {
                return;
            }

            if (processFor(d2, d1, value)) {
                return;
            }

        }

    }

    private boolean processFor(ArrayDeque<Node> d1, ArrayDeque<Node> d2, Integer value) {

        while (d1.size() > 0) {

            Node node = d1.removeLast();

            if (node.getLeft() != null) {
                d2.addFirst(node.getLeft());
            } else {
                node.setLeft(new Node(value));

                d1.addLast(node);
                startD = d1;
                otherD = d2;

                return true;
            }

            if (node.getRight() != null) {
                d2.addFirst(node.getRight());
            } else {
                node.setRight(new Node(value));

                d2.removeFirst();
                d1.addLast(node);
                startD = d1;
                otherD = d2;

                return true;
            }

        }

        return false;
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

    public void convert() {
        Convertor c = new Convertor();
        c.convertToBST(head);
    }
}

class Node {
    private Node left, right;
    private Integer value;

    @Override
    public String toString() {
        return value + " ";
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

    public void setValue(Integer value) {
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
}
