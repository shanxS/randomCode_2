public class BinaryCode {

    private Node head;

    public void run() {

        init();
        print(head);
        System.out.print("--------");

        Convertor c = new Convertor();
        c.convertToBST(head);
        c.convertToBST(head);

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

        head.getLeft().setRight(new Node(4));
        head.getLeft().setLeft(new Node(8));

    }
}

class Convertor {

    private Node headHolder;

    public void print(Node node) {
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


    public void convertToBST(Node head) {

        headHolder = head;

        checkAndCorrect (null, head, null);


    }

    private void checkAndCorrect(Node small, Node node, Node big) {

        if (node == null) {
            return;
        }

        checkAndCorrect(small, node.getLeft(), node);
        checkAndCorrect(node, node.getRight(), big);

        if (small != null && big != null) {

            int min = Math.min(node.getValue(), Math.min(small.getValue(), big.getValue()));
            int max = Math.max(node.getValue(), Math.max(small.getValue(), big.getValue()));
            int mid = (node.getValue() + big.getValue() + small.getValue())
                    - (min + max);

            node.setValue(mid);
            big.setValue(max);
            small.setValue(min);

        } else if (small != null) {

            int min = Math.min(node.getValue(), small.getValue());
            int max = Math.max(node.getValue(), small.getValue());

            small.setValue(min);
            node.setValue(max);

        } else if (big != null) {

            int min = Math.min(node.getValue(), big.getValue());
            int max = Math.max(node.getValue(), big.getValue());

            node.setValue(min);
            big.setValue(max);

        } else {

            System.out.print("soemthing fucnked for " + node.getValue());

        }


    }

}

class Node {
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