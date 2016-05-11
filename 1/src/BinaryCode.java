public class BinaryCode {

    private int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

    public void run() {

        int gStart = -1;
        int gEnd = -1;
        int gMax = Integer.MIN_VALUE;

        int start = 0;
        int end = 0;
        int max = A[0];
        for (int i=1; i<A.length; ++i) {
            if (A[i] > 0 && max <= 0) {
                max = A[i];
                start = i;
                end = i;
            } else if (max > 0) {

                max += A[i];
                end = i;

            }

            if (gMax < max) {
                gMax = max;
                gStart = start;
                gEnd = end;
            }
        }

        System.out.print(gStart + " " + gEnd + " " + gMax);

    }

}
