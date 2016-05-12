import java.util.Arrays;

public class BinaryCode {

    private Integer[] A = {2,4,1,3,6};

    public void run() {
        int[] count = new int[10];
        for (int i=0; i<A.length; ++i) {
            ++count[A[i]];
        }

        for (int i=1; i<count.length; ++i) {
            count[i] += count[i-1];
        }

        Integer[] sorted = new Integer[A.length];
        for (int i=0; i<A.length; ++i) {
            sorted[count[A[i]] - 1] = A[i];
            --count[A[i]];
        }

        System.out.print(Arrays.deepToString(sorted));
    }
}