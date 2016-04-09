/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    public Integer[] A = {-2, -3, -4, -1, -2, -1, -5, -3};
    //public Integer[] A = {2,-3,5};


    public void run() {
        Integer gMax = A[0];
        Integer gStart = 0;
        Integer gEnd = 0;

        Integer lMax = A[0];
        Integer lStart = 0;
        Integer lEnd = 0;

        for (Integer i=1; i<A.length; ++i) {
            if (lMax <= 0 && lMax < A[i]) {
                lMax = A[i];
                lStart = i;
                lEnd = i;
            } else if (lMax > 0) {
                lMax += A[i];
                lEnd = i;
            }

            if (lMax > gMax) {
                gMax = lMax;
                gEnd = lEnd;
                gStart = lStart;
            }
        }

        System.out.print(gMax + " " + gStart + " " + gEnd);

    }
}
