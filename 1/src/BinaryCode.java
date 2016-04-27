public class BinaryCode {

    private Node[] A = {
            new Node(1,3),
            new Node(7,9),
            new Node(4,6),
            new Node(10,13)
    };

    public void run() {
        sort(0, A.length-1);

        Integer prevEnd = A[0].second;
        for (Integer i=1; i<A.length; ++i) {
            if (prevEnd > A[i].first) {
                System.out.println("overlap " + A[i-1] + " " + A[i]);
            }

            prevEnd = A[i].second;
        }

    }

    private void sort(Integer start, Integer end) {
        if (start >= end) {
            return;
        }

        Integer pivot = qSort(start, end);
        sort(start, pivot-1);
        sort(pivot+1, end);

    }

    private Integer qSort(Integer start, Integer end) {
        Integer marker = start-1;
        Integer pivotValue = A[end].first;

        for (Integer i=start; i<end; ++i) {
            if (A[i].first < pivotValue) {
                ++marker;
                swap(marker, i);
            }
        }

        swap(marker+1, end);
        return marker+1;
    }

    private void swap(Integer from, Integer to) {
        Node tmp = A[from];
        A[from] = A[to];
        A[to] = tmp;
    }

}

class Node {
    public Integer first, second;

    public Node(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "Node{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}