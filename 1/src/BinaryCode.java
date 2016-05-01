public class BinaryCode {

    private Integer[] A = {1, 5, 3, 4, 2};
    private Integer k=3;

    public void run() {

        sort(0, A.length-1);

        Integer start = 0, end = A.length-1;
        while (start < end) {

            Integer diff = A[end]-A[start];

            if (diff == k) {
                System.out.println(A[end] + " " + A[start]);

                --end;
                ++start;
            } else if (diff < k) {
                --end;
            } else {
                ++start;
            }
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
        Integer pivotValue = A[end];

        for (Integer i=start; i<end; ++i) {
            if (A[i] <= pivotValue) {
                ++marker;
                swap(i, marker);
            }
        }

        swap(marker+1, end);
        return marker+1;
    }

    private void swap(Integer from, Integer to) {
        Integer tmp = A[from];
        A[from] = A[to];
        A[to] = tmp;
    }
}