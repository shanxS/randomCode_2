import java.util.Arrays;

public class BinaryCode {

    private Integer[] A = {23, 10, 20, 11, 12, 6, 7};

    public void run() {

        int counter = A.length-1;
        while (counter > 0) {
            int maxIndex = findMaxIndex(0, counter);
            flip(maxIndex);
            flip(counter);

            --counter;
        }

        System.out.print(Arrays.deepToString(A));
    }

    private int findMaxIndex(int start, int end) {
        int max = A[start];
        int index = start;

        for (int i=start; i<=end; ++i) {
            if (A[i] > max) {
                max = A[i];
                index = i;
            }
        }


        return index;
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