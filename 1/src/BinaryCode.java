public class BinaryCode {

    private Integer[] A = {3, 1, 4, 6, 5};

    public void run() {

        sort(0, A.length-1);

        for (Integer i=0; i<A.length; ++i) {
            A[i] = (int) Math.pow(A[i], 2);
        }

        for (Integer i=A.length-1; i>=2; --i) {
            Integer start = 0;
            Integer end = i-1;
            while (start < end) {
                if (A[start] + A[end] == A[i]) {
                    System.out.print(A[start] + " " + A[end] + " " + A[i]);

                    ++start;
                    --end;
                } else if (A[start] + A[end] < A[i]) {
                    ++start;
                } else if (A[start] + A[end] > A[i]) {
                    --end;
                }
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

        Integer pivotValue = A[end];
        Integer marker = start-1;

        for (Integer i=start; i<end; ++i) {
            if (A[i] <= pivotValue) {
                ++marker;
                swap(marker, i);
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