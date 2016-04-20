public class Algo {

    private Integer[] A = {1, 4, 45, 6, 10, 8};
    private Integer target = 22;

    public void run() {

        sort(0, A.length-1);

//        for (Integer ele : A) {
//            System.out.print(ele + " ");
//        }

        for (Integer i=A.length-1; i>=0; --i) {
            Integer sum = target - A[i];

            Integer start = 0, end = i-1;
            while (start < end) {
                if (sum == A[start] + A[end]) {
                    System.out.println(A[start] + " " + A[end] + " " + A[i]);
                    ++start;
                    --end;
                } else if (sum > A[start] + A[end]) {
                    ++start;
                } else {
                    --end;
                }
            }
        }

    }

    private void sort(Integer start, Integer end) {
        if (start >= end) {
            return;
        }

        Integer pivot = quickSort(start, end);
        sort(start, pivot-1);
        sort(pivot+1, end);

    }

    private Integer quickSort(Integer start, Integer end) {
        Integer pivotValue = A[end];
        Integer marker = start-1;

        Integer counter = start;
        while (counter < end) {
            if (A[counter] < pivotValue) {
                ++marker;
                swap(marker, counter);
            }

            ++counter;
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