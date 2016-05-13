import java.util.Arrays;

public class BinaryCode {

    private Integer[] A = {23, 10, 20, 11, 12, 6, 7};

    public void run() {

        int counter = 1;
        while (counter < A.length) {
            int maxIndex = findMax (0, counter);
            if (maxIndex > -1 ) {
                flip(maxIndex-1);
                flip(counter-1);
                flip(counter);
                flip(maxIndex);
            }

            System.out.println(Arrays.deepToString(A));

            ++counter;
        }


        System.out.print(Arrays.deepToString(A));
    }

    private int findMax(int start, int targetIndex) {
        int target = A[targetIndex];
        int end = targetIndex-1;

        if (start > end) {
            return -1;
        }

        while (start <= end) {
            int mid = Math.min(start, end) + ((Math.abs(start-end))/2);

            if (A[mid] > target) {
                if (mid == start
                        || (mid-1 >= start && A[mid-1] < target)) {
                    return mid;
                } else {
                    end = mid-1;
                }
            } else {
                start = mid+1;
            }
        }

        return -1;
    }

    private void flip (int i) {
        int rev = i;
        int fwd = 0;

        while (rev > fwd) {
            swap (rev, fwd);
            --rev;
            ++fwd;
        }
    }

    private void swap(int rev, int fwd) {
        int tmp = A[rev];
        A[rev] = A[fwd];
        A[fwd] = tmp;
    }

}