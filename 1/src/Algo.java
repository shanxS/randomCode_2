import java.util.*;

public class Algo {


    private Integer[] A = {1, -2, -3, 0, 7, -8, -2};
    private Integer maxProd = Integer.MIN_VALUE;
    Integer thisProd = 1;
    Integer minNegative = Integer.MAX_VALUE;

    public void run() {


        for (Integer i=0; i<A.length; ++i) {

            if (A[i] == 0) {
                updateMax();
            } else {

                thisProd *= A[i];
                minNegative = (A[i] < 0) ? Math.min(minNegative, Math.abs(A[i])) : minNegative;

            }

        }
        updateMax();

        System.out.print(maxProd);

    }

    private void updateMax() {

        if (thisProd < 0) {
            thisProd /= (minNegative * -1);
        }
        maxProd = Math.max(maxProd, thisProd);

        thisProd = 1;
        minNegative = Integer.MAX_VALUE;
    }
}