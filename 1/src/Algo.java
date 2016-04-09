/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

//    public Integer[] A = {-2, -3, -4, -1, -2, -1, -5, -3};
public Integer[] A = {2,-3,5};


    public void run() {
        Integer gMax = null;
        Integer gStart = null;
        Integer gEnd = null;

        Integer lMax = null;
        Integer lStart = null;
        Integer lEnd = null;

        for (Integer i=0; i<A.length; ++i) {
            if (lMax == null && A[i] > 0) {
                lMax = A[i];
                lStart = i;
                lEnd = i;
            } else if (lMax != null) {
                lMax += A[i];
                lEnd = i;

                if (lMax <= 0) {
                    lMax = null;
                    lStart = null;
                    lEnd = null;
                }
            }

            if (lMax != null) {
                if (gMax == null || lMax > gMax) {
                    gMax = lMax;
                    gStart = lStart;
                    gEnd = lEnd;
                }
            }
        }

        System.out.print(gMax + " " + gStart + " " + gEnd);
    }
}
