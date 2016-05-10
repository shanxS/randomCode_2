import java.util.ArrayList;
import java.util.List;

public class BinaryCode {

    private Node[] A = {new Node(1,3)
            , new Node(2,4)
            , new Node(5,7)
            , new Node(6,8)
    };

    public void run() {

        sort(0, A.length-1);

        List<Node> merged = new ArrayList<>();
        for (Integer i=0; i<A.length; ++i) {
            if (i+1 < A.length) {
                if (A[i].end > A[i+1].start) {
                    merged.add(new Node(A[i].start, A[i+1].end));
                    ++i;
                } else {
                    merged.add(A[i]);
                    merged.add(A[i+1]);
                }
            } else {
                merged.add(A[i]);
            }
        }

        System.out.print(merged);

    }

    private void sort(int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = qSort(start, end);
        sort(start, pivot-1);
        sort(pivot+1, end);
    }

    private int qSort(int begin, int stop) {
        int marker = begin-1;
        int pivotValue = A[stop].start;

        for (Integer i=begin; i<stop; ++i) {
            if (A[i].start <= pivotValue) {
                ++marker;
                swap(i, marker);
            }
        }

        swap(marker+1, stop);
        return marker+1;
    }

    private void swap(int from, int to) {
        Node tmp = A[from];
        A[from] = A[to];
        A[to] = tmp;
    }
}

class Node {
    public int start, end;

    public Node(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + "," + end + "]";
    }
}