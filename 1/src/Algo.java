import java.util.Comparator;

/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] A = {5, 2, 2, 8, 5, 6, 8, 8};

    public void run() {
        Sorter sorter = new Sorter(new MyComparator());
        sorter.sort(A);
        for (Integer ele : A) {
            System.out.print(ele + " ");
        }
    }
}

class Sorter<T> {
    private T[] A;
    private Comparator comparator;

    public Sorter(Comparator comparator) {
        this.comparator = comparator;
    }

    public void sort(T[] A) {
        this.A = A;

        sort(0, A.length-1);
    }

    private void sort(int start, int end) {
        if (start >= end) {
            return;
        }

        Integer pivotIndex = quickSort(start, end);
        sort(start, pivotIndex-1);
        sort(pivotIndex+1, end);
    }

    private Integer quickSort(int start, int end) {
        Integer marker = start - 1;
        T pivotValue = A[end];

        for (Integer i=start; i<end; ++i) {
//            if (A[i] < pivotValue) {
            if (comparator.compare(A[i], pivotValue) == 1){
                ++marker;
                swap(marker, i);
            }
        }

        swap (marker+1, end);
        return marker+1;
    }

    private void swap(int from, int to) {
        T temp = A[from];
        A[from] = A[to];
        A[to] = temp;
    }
}

class MyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2) {
            return -1;
        } else if (o1 < o2) {
            return 1;
        } else {
            return 0;
        }
    }
}