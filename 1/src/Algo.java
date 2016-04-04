/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] A = {1, 60, -10, 70, -80, 85};

    public void run() {

        QuickSort qs = new QuickSort();
        qs.sort(A);

        Integer end = A.length-1;
        Integer start = 0;
        Integer minValue = Integer.MAX_VALUE;
        while (end > start) {
            Integer diff = A[end] + A[start];
            minValue = (Math.abs(diff) < Math.abs(minValue)) ? diff : minValue;

            if (diff > 0) {
                --end;
            } else  if (diff < 0) {
                ++start;
            }
            else if (diff == 0) {
                break;
            }
        }

        System.out.print(minValue);

    }
}

class QuickSort {
    private Integer[] A;
    public void  sort (Integer[] A) {
        this.A = A;
        doItFor(0, A.length-1);
    }

    private void doItFor(int start, int end) {
        if (start >= end) {
            return;
        }

        Integer marker = start - 1;
        Integer pivotValue = A[end];

        for (Integer j=start; j<end; ++j) {
            if (A[j] <= pivotValue) {
                ++marker;
                swap(marker, j);
            }
        }

        swap(marker+1, end);

        doItFor(start, marker);
        doItFor(marker+2, end);
    }

    private void swap(Integer from, Integer to) {
        Integer temp = A[from];
        A[from] = A[to];
        A[to] = temp;
    }
}