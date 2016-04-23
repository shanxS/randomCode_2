import java.util.*;

public class Algo {

    private Integer[] A = {10, 2, 3, 4, 5, 9, 7, 8};
    private Integer target = 23;

    public void run() {

        sort(0, A.length-1);


        for (Integer i=A.length-1; i>=3; --i) {
            for (Integer j=i-1; j>=2; --j) {
                Integer diff = target - (A[i] + A[j]);
                Integer fwd = 0, rev = j-1;
                while (fwd < rev) {
                    Integer sum = A[rev] + A[fwd];
                    if (sum == diff) {
                        System.out.println(A[i] + " " + A[j] + " " + A[fwd] + " " + A[rev]);
                        break;
                    } else if (sum < diff) {
                        ++fwd;
                    } else if (sum > diff) {
                        --rev;
                    }
                }
            }
        }

    }

    private Integer find(Integer diff, Integer start, Integer end) {
        while (start <= end) {

            Integer mid = Math.min(start, end) + ((Math.abs(A[start]-A[end]))/2);

            if (A[mid] == diff) {
                return mid;
            } else if (A[mid] < diff) {
                start = mid+1;
            } else {
                end = mid-1;
            }

        }

        return null;
    }

    public void sort(Integer start, Integer end) {

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
                swap (marker, i);
            }
        }

        swap(marker+1, end);
        return marker+1;
    }

    private void swap (Integer from, Integer to) {
        Integer tmp = A[from];
        A[from] = A[to];
        A[to] = tmp;
    }

}