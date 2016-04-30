public class BinaryCode {


    private Integer[] A = {7, 10, 4, 3, 20, 15};
    private Integer k = 3;

    public void run() {

        sort(0, A.length-1);
        System.out.print("--- " + A[k]);
    }

    private void sort(Integer start, Integer end) {

        if (start >= end) {

            if (start== end) {
                System.out.println("start " + start);
            }

            return;
        }

        Integer pivot = qSort(start, end);
        System.out.print(pivot + " ");
        sort(start, pivot-1);
        sort(pivot+1, end);

    }

    private Integer qSort(Integer start, Integer end) {
        Integer pivotValue = A[end];
        Integer marker = start - 1;

        Integer counter = start;
        while (counter < end) {
            if (A[counter] <= pivotValue) {
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