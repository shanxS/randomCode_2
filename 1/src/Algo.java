import lombok.*;
import java.util.*;

public class Algo {

    private int[] A = {100, 50, 210, 25, 60, 110, 250, 55, 70};

    public void run() {


        BST tree = new BST();
        for (Integer i : A) {
            tree.insert(i);
        }

        tree.print();
        System.out.println ("breadthwise ");
        tree.breadthWisePrint();

    }
}


class BST {
    private Node head;

    public void insert(int val) {
        if (head == null) {
            head = new Node (val);
        } else {
            insert(head,val);
        }
    }


    public void breadthWisePrint() {
        breadthWisePrint(head);
    }

    private void breadthWisePrint(Node node) {

        Queue<Node> stack1 = new ArrayDeque<>();
        Queue<Node> stack2 = new ArrayDeque<>();

        stack1.add(node);
        while (stack1.size() > 0 || stack2.size() > 0) {

            while (stack1.size() > 0) {
                Node thisNode = stack1.remove();
                System.out.print(thisNode.getValue() + " ");

                if (thisNode.getLeft() != null) {
                    stack2.add(thisNode.getLeft());
                }
                if (thisNode.getRight() != null) {
                    stack2.add(thisNode.getRight());
                }
            }

            System.out.println();

            while (stack2.size() > 0) {
                Node thisNode = stack2.remove();
                System.out.print(thisNode.getValue() + " ");

                if (thisNode.getLeft() != null) {
                    stack1.add(thisNode.getLeft());
                }
                if (thisNode.getRight() != null) {
                    stack1.add(thisNode.getRight());
                }
            }
            System.out.println();

        }

    }


    private void insert(Node node, int val) {
        if (node.getValue() < val) {
            if (node.getRight() == null) {
                node.setRight(new Node(val));
            } else {
                insert(node.getRight(), val);
            }
        } else if (node.getValue() > val) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(val));
            } else {
                insert(node.getLeft(), val);
            }
        } else {
            System.out.print("same value " + val);
        }
    }

    public void print() {
        print(head);
    }

    private void print(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.getValue()+ " - ");
        if(node.getLeft() != null) {
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
    @Setter @Getter
    private Node left, right;
    @Getter
    private Integer value;

    public Node (int val) {
        this.value = val;
    }
}