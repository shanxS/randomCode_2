import java.util.ArrayList;
import java.util.List;

public class BinaryCode {

    private Node head;

    public void run() {

        init();
        print(head);
        System.out.print("----------");
        Convertor c = new Convertor();
        c.convert(head);
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

    private void init() {
        head = new Node(10);
        head.setLeft(new Node(2));
        head.setRight(new Node(7));

        head.getLeft().setLeft(new Node(8));
        head.getLeft().setRight(new Node(4));

    }
}

class Convertor {
    private List<Integer> numbers;

    public void convert(Node head) {
        numbers = new ArrayList<>();

        traverse(head);
        sort(0, numbers.size()-1);
        applyNumbers(head, 0);

    }

    private int applyNumbers(Node node, int pos) {
        if (node == null) {
            return pos;
        }

        pos = applyNumbers(node.getLeft(), pos);

        node.setValue(numbers.get(pos));
        ++pos;

        return applyNumbers(node.getRight(), pos);
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
            if (numbers.get(i) < pivotValue) {
                ++marker;
                swap(i, marker);
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

class Node{
    private Node left, right;
    private Integer value;

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