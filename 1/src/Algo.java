/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] A = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
//    private Integer[] A = {0, 1, 15, 25, 6, 7, 30, 40, 50};

    public void run() {
        Integer maxSoFarBlipped = null;
        Integer maxBlippingPoint = null;
        Integer i=0;
        while (i<A.length-1) {
            if (A[i] > A[i + 1]) {
                if (maxSoFarBlipped == null || A[maxSoFarBlipped] < A[i]) {
                    maxSoFarBlipped = i;

                    while (i<A.length-1 && A[maxSoFarBlipped] > A[i+1]) {
                        maxBlippingPoint = i+1;
                        ++i;
                    }
                }

            } else {
                ++i;
            }
        }

        Integer minSoFarBlipped = null;
        Integer minBlippingPoint = null;
        i=A.length-1;
        while (i>0) {
            if (A[i] < A[i-1]) {
                if (minSoFarBlipped == null || A[minSoFarBlipped] > A[i]) {
                    minSoFarBlipped = i;

                    while (i>0 && A[minSoFarBlipped] < A[i-1]) {
                        minBlippingPoint = i-1;
                        --i;
                    }
                 }
            } else {
                --i;
            }
        }

        System.out.print(maxBlippingPoint + " " + minBlippingPoint);

    }

}
