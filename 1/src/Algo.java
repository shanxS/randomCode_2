/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    public Integer[] A = {2, 3, -4, 1, 2, -1, -5, 3};
    //public Integer[] A = {2,-3,5};


    public void run() {
        Integer gMin = null;
        Integer gStart = null;
        Integer gEnd = null;

        Integer lMin = null;
        Integer lStart = null;
        Integer lEnd = null;

        for (Integer i=0; i<A.length; ++i) {
            if (lMin == null && A[i] <= 0) {
                lMin = A[i];
                lStart = i;
                lEnd = i;
            } else if (lMin != null) {
                lMin += A[i];
                lEnd = i;

                if (lMin >= 0) {
                    lMin = null;
                    lStart = null;
                    lEnd = null;
                }
            }

            if (lMin != null) {
                if (gMin == null || lMin < gMin) {
                    gMin = lMin;
                    gStart = lStart;
                    gEnd = lEnd;
                }
            }
        }

        System.out.print(gMin + " " + gStart + " " + gEnd);
    }
}
