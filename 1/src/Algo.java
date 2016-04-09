/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] A = {5,4,3,2,1};//{-7, -1, -5, -6, -3, -2};//{80, 2, 6, 3, 100};//{2, 3, 10, 6, 4, 8, 1};

    public void run() {
        Integer gMax = null;
        Integer gStart = null;
        Integer gEnd = null;

        Integer lMax = null;
        Integer lStart = null;
        Integer lEnd = null;

        for (Integer i=1; i<A.length; ++i) {
            Integer value = A[i] - A[i-1];

            if (lMax == null && value > 0) {
                lMax = value;
                lStart = i;
                lEnd = i;
            } else if (lMax != null) {
                lMax += value;
                lEnd = i;

                if (lMax <= 0) {
                    lMax = null;
                    lStart = null;
                    lEnd = null;
                }
            }

            if (lMax != null) {
                if (gMax == null || gMax < lMax) {
                    gMax = lMax;
                    gStart = lStart;
                    gEnd = lEnd;
                }
            }
        }

        System.out.print(gMax + " "
                + ((gStart != null) ? (gStart-1) : ("null")) + " "
                + ((gEnd != null) ? (gEnd) : ("null")));
    }
}
