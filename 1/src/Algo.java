public class Algo {

    private Integer[] A = {6, 5, 4, 3, 2, 1};

    public void run() {
        BST bst = new BST();

        for (Integer i=0; i<A.length; ++i) {
            Integer ele = A[i];
            bst.insert(ele, i);
        }

        System.out.print(bst.getMaxGap());
    }
}

class BST{
    private Node head;
    private Integer maxGap = Integer.MIN_VALUE, start, stop;

    public Integer getMaxGap() {
        System.out.println(start + " " + stop);
        return maxGap;
    }


    public void insert(Integer value, Integer selfIndex) {
        if (head == null) {
            head = new Node(value, selfIndex);
        } else {
            insert(head, value, selfIndex);
        }
    }

    private void insert(Node node, Integer value, Integer selfIndex) {

        if (node.getValue() < value) {

            if (node.getRight() == null) {
                Node rightNode = new Node(value, selfIndex);
                rightNode.setLeftIndex(node.getLeftIndex());

                if (selfIndex - node.getLeftIndex() > maxGap) {
                    stop = node.getLeftIndex();
                    start = selfIndex;
                    maxGap = selfIndex - node.getLeftIndex();
                }

                node.setRight(rightNode);
            } else {
                insert(node.getRight(), value, selfIndex);
            }


        } else if (node.getValue() > value) {

            if (node.getLeft() == null) {
                Node leftNode = new Node(value, selfIndex);
                node.setLeft(leftNode);

            } else {
                insert(node.getLeft(), value, selfIndex);
            }

        }


    }
}


class Node {
    private Node left, right;
    private Integer value, leftIndex, sellIndex;

    public Node(Integer value, Integer selfIndex) {
        this.value = value;
        this.sellIndex = selfIndex;
    }

    public Integer getSelfIndex() { return sellIndex; }

    public Integer getLeftIndex() {
        if (leftIndex == null) {
            return sellIndex;
        } else {
            return leftIndex;
        }

    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeftIndex(Integer leftIndex) {
        this.leftIndex = leftIndex;
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