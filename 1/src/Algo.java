/**
 * @author shashaku on 29/03/16.
 */
public class Algo {
    public void run() {
        for (Integer i : A) {
            System.out.print(i + " ");
        }
        System.out.println();

        quickSort(0, A.length-1);

        for (Integer i : A) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    private Integer[] A = {3,7,8,5,2,1,9,5,4};


    public void quickSort(Integer start, Integer end) {

        if (start >= end) {
            return;
        }

        Integer pivot = execute(start, end);
        quickSort(start, pivot-1);
        quickSort(pivot+1, end);

    }

    private Integer execute(Integer start, Integer end) {
        Integer marker = start-1;
        Integer pivotValue = A[end];

        for (Integer j=start; j<end; ++j) {
            if (A[j] <= pivotValue) {
                ++marker;
                swap(marker, j);
            }
        }

        swap(marker+1, end);
        return marker+1;
    }

    private void swap(Integer from, Integer to ) {
        Integer temp = A[from];
        A[from] = A[to];
        A[to] = temp;
    }
}
