public class BinaryCode {


    private Integer[] A = {7, 10, 4, 3, 20, 15};
    private Integer k = 3;

    public void run() {

        Integer v = sort(0, A.length-1);
        System.out.print(v);
    }

    private Integer sort(Integer start, Integer end) {
        if (start > end) {
            return null;
        }

        if (start == end) {

            if (start == k) {
                return A[start];
            } else {
                return null;
            }
        }

        Integer pivot = qSort(start, end);
        System.out.println("pivot " + pivot);
        if (pivot == k) {
            return A[k];
        }

        Integer res1 = sort(start, pivot-1);
        if (res1 != null) {
            return res1;
        }

        Integer res2 = sort(pivot+1, end);
        if (res2 != null) {
            return res2;
        }

        return null;
    }

    private Integer qSort(Integer start, Integer end) {
        Integer pivotValue = A[end];
        Integer marker = start-1;

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