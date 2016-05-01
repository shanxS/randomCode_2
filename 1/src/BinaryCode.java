import java.util.ArrayList;
import java.util.List;

public class BinaryCode {

    private Integer[] A1 = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
    private Integer[] A2 = {2, 1, 8, 3};

    public void run() {
        BST bst = new BST();
        for (Integer ele : A1) {
            bst.insert(ele);
        }

        for (Integer ele : A2) {
            Integer count = bst.getCount(ele);
            while (count > 0) {
                System.out.print(ele + " ");
                --count;
            }
        }

        for (Integer ele : bst.getUnvisited()) {
            System.out.print(ele + " ");
        }

    }
}

class BST {
    private Node head;2 2 1 1 8 8 3 5 6 7 9

    public void insert(Integer value) {
        if (head == null) {
            head = new Node(value);
        } else {
            insert(head, value);
        }
    }

    private void insert(Node node, Integer value) {
        if (node.getValue() < value) {
            if (node.getRight() == null) {
                node.setRight(new Node(value));
            } else {
                insert(node.getRight(), value);
            }
        } else if (node.getValue() > value) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(value));
            } else {
                insert(node.getLeft(), value);
            }
        } else {
            node.bumpCount();
        }
    }

    public void print() {
        print(head);
    }

    private void print(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.getValue() + "(" + node.getCount() + ")" + " - ");
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

    public Integer getCount(Integer ele) {
        Node node = findNode(head, ele);
        if (node == null) {
            return 0;
        } else {
            return node.getCount();
        }
    }

    private Node findNode(Node node, Integer ele) {
        if (node == null) {
            return null;
        }

        if (node.getValue() == ele) {
            node.setVisited();
            return node;
        } else if (node.getValue() > ele) {
            return findNode(node.getLeft(), ele);
        } else {
            return findNode(node.getRight(), ele);
        }
    }

    public List<Integer> getUnvisited() {
        List<Integer> list = new ArrayList<>();

        collectUnvisited(head, list);

        return list;
    }

    private void collectUnvisited(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }

        collectUnvisited(node.getLeft(), list);
        if (!node.getVisited()) {
            list.add(node.getValue());
        }
        collectUnvisited(node.getRight(), list);
    }
}

class Node {
    private Node left, right;
    private Boolean visited;
    private Integer value;
    private Integer count;

    public Node(Integer v) {
        this.value = v;
        this.count = 1;
        this.visited = false;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited() {
        this.visited = true;
    }

    public void bumpCount() {
        ++count;
    }

    public Integer getCount() {
        return count;
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