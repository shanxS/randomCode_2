import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    public void run() {
        Integer[] A = {2, 4, 1, 3, 5};//{1, 20, 6, 4, 5};
        InversionKeeper ik = new InversionKeeper();
        for (Integer ele : A) {
            ik.insert(ele);
        }

        ik.printInversions();

    }
}

class InversionKeeper {
    private Node head;
    private Map<Integer, List<Integer>> inversions;

    public InversionKeeper() {
        inversions = new HashMap<>();
    }

    public void insert(Integer data) {
        if (head == null) {
            head = new Node(data);
        } else {
            insert(head, data);
        }
    }

    public void printInversions() {
        for (Map.Entry<Integer, List<Integer>> entry : inversions.entrySet()) {
            System.out.println(entry);
        }
    }

    private void insert(Node node, Integer data) {
        if (node.getData() > data) {
            populateInversions(node, data);
            if (node.getLeft() != null) {
                insert(node.getLeft(), data);
            } else {
                node.setLeft(new Node(data));
            }
        } else  if (node.getData() < data) {
            if (node.getRight() != null) {
                insert(node.getRight(), data);
            } else {
                node.setRight(new Node(data));
            }
        }
    }

    private void populateInversions(Node node, Integer data) {
        if (node == null) {
            return;
        }

        List<Integer> inversionData = inversions.get(node.getData());
        if (inversionData == null) {
            inversionData = new ArrayList<>();
            inversions.put(node.getData(), inversionData);
        }
        inversionData.add(data);

        populateInversions(node.getRight(), data);
    }

    public void print(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.getData() + " - ");
        if (node.getLeft() != null) {
            System.out.print(node.getLeft().getData());
        }
        System.out.print(", ");
        if (node.getRight() != null) {
            System.out.print(node.getRight().getData());
        }
        System.out.println();

        print(node.getLeft());
        print(node.getRight());
    }
}

class Node {
    private Integer data;
    private Node left, right;

    public Node (Integer data) {
        this.data = data;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
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
}
