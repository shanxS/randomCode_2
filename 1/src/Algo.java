/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    public void run() {
        Integer[] A = {2, 5, 2, 8, 5, 6, 8, 8};
        BST bst = new BST();
        for (Integer ele : A) {
            bst.add(ele);
        }

        bst.print(bst.getHead());
    }
}


class BST {
    private Node head;

    public void add(Integer data) {
        if (head == null) {
            head = new Node (data);
        } else {
            insert(head, data);
        }
    }

    private void insert(Node node, Integer data) {
        if (node.getData() > data) {
            if (node.getLeft() != null) {
                insert(node.getLeft(), data);
            } else {
                node.setLeft(new Node(data));
            }
        } else if (node.getData() < data) {
            if (node.getRight() != null) {
                insert(node.getRight(), data);
            } else {
                node.setRight(new Node(data));
            }
        } else if (node.getData() == data) {
            node.incrementCount();
        }
    }

    public Node getHead() { return head; }

    public void print(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.getData() + "[" + node.getCount() + "]" + " - ");
        if (node.getLeft() != null) {
            System.out.print(node.getLeft().getData() + " ");
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
    private Node left, right;
    private Integer data, count;

    public Node (Integer data) {
        this.data = data;
        this.count = 1;
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

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public void incrementCount() {
        ++count;
    }

    public Integer getCount() {
        return count;
    }
}