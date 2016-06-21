import lombok.*;

public class Main {
    public static void main(String[] args) {
        Algo algo = new Algo();
        algo.run();
    }
}

class Algo {
    private int[] A = {
            1000,
            700, 1010,
            500,800,1020,
            400,600,900,
            550,850,950,
            530,570,970
    };

    private int[] A2 = {
            600,
            550,
            530
    };

    public void run() {
        BST main = new BST();
        for (Integer i : A) {
            main.insert(i);
        }

        BST sub = new BST();
        for (Integer i : A2) {
            sub.insert(i);
        }

        SubTreeTester tester = new SubTreeTester();
        System.out.print(tester.test(sub.getHead(), main.getHead()));
    }
}

class SubTreeTester {
    public boolean test(Node subHead, Node head) {
        Node nodeInMain = find(head, subHead.getValue());
        if (nodeInMain == null) {
            return false;
        }
        return testTree(nodeInMain, subHead);
    }

    private boolean testTree(Node sub, Node main) {
        if ((sub == null && main != null)
                || (sub != null && main == null)) {
            return false;
        } else if (sub != null && main != null) {
            if (!sub.getValue().equals(main.getValue())) {
                return false;
            } else {
                if (!testTree(sub.getLeft(), main.getLeft())
                        || !testTree(sub.getRight(), main.getRight())) {
                    return false;
                }
            }
        }

        return true;
    }

    private Node find(Node node, int val) {
        if (node == null) {
            return null;
        }

        if (node.getValue().equals(val)) {
            return node;
        }

        Node leftSubTreeResult = find(node.getLeft(), val);
        if (leftSubTreeResult != null) {
            return leftSubTreeResult;
        }

        Node rightSubTreeResult = find(node.getRight(), val);
        if (rightSubTreeResult != null) {
            return rightSubTreeResult;
        }

        return null;
    }
}

class BST {
    @Getter
    private Node head;

    public void insert(int val) {
        if (head == null) {
            head = new Node(val);
        } else {
            insert(head, val);
        }
    }

    private void insert(Node node, int val) {
        if (node.getValue() > val) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(val));
            } else {
                insert(node.getLeft(), val);
            }
        } else if (node.getValue() < val) {
            if (node.getRight() == null) {
                node.setRight(new Node(val));
            } else {
                insert(node.getRight(), val);
            }
        } else {
            System.out.print("duplicate value " + val);
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
    @Setter @Getter
    private Node left, right;

    @Setter @Getter
    private Integer value;

    public Node (int val) {
        this.value = val;
    }
}