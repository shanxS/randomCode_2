import java.util.Random;

public class BinaryCode {


    private Integer[] A = {7, 10, 4, 3, 20, 15};
    private Integer k = 6;

    public void run() {

        sort (0, A.length-1);
//        for (Integer ele : A) {
//            System.out.print(ele + " ");
//        }

    }

    private void sort(Integer start, Integer end) {
        if (start > end) {
            return;
        }

        Integer count = end - start + 1;
        Random rand  = new Random();
        swap(end, start + rand.nextInt(count));

        Integer pivot = qSort(start, end);
        if (pivot == k-1) {
            System.out.print(A[pivot]);
            return;
        }

        sort(start, pivot-1);
        sort(pivot+1, end);
    }

    private Integer qSort(Integer start, Integer end) {

        Integer marker = start-1;
        Integer pivotValue = A[end];

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