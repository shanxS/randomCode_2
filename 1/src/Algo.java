/**
 * @author shashaku on 29/03/16.
 */
public class Algo {
    private Integer[] A = {-2, -3, 4, -1, -2, 1, 5, -30, 12};


    public void run() {
        Integer mStart = null, mEnd = null, mSum = 0;
        Integer rStart = null, rEnd = null, rSum = 0;

        for (Integer i=0; i<A.length; ++i) {
            rSum += A[i];
            if (rSum <= 0) {
                rStart = null; rEnd = null; rSum = 0;
            }
            else {

                if (rStart == null) {
                    rStart = i;
                    rEnd = i;
                } else {
                    rEnd = i;
                }

                if (rSum > mSum) {
                    mSum = rSum;
                    mStart = rStart;
                    mEnd = rEnd;
                }
            }
        }

        System.out.print(mStart + " " + mEnd + " " + mSum);
    }
}
