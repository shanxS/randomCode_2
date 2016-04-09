/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] A = {-2, -3, 4, -1, -2, 1, 5, -3};


    public void run() {
        Integer gMax = A[0];
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


                if (lMax > gMax) {
                    gMax = lMax;
                    gStart = lStart;
                    gEnd = lEnd;
                } else if (lMax <= 0) {
                    lMax = null;
                    lStart = null;
                    lEnd = null;
                }
            }
        }

        System.out.print(gMax + " " + gStart + " " + gEnd);
    }
}
