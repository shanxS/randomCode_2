public class BinaryCode {

    Integer[] A = {-1, 40, -14, 7, 6, 5, -4, -1};

    public void run() {

        Integer ksum = kadane();

        Integer totalSum = 0;
        for (Integer i=0; i<A.length; ++i) {
            totalSum += A[i];
            A[i] = -A[i];
        }
        Integer ksum2 = totalSum + kadane();

        System.out.print(Math.max(ksum, ksum2));

    }

    private Integer kadane() {
        Integer gMax = Integer.MIN_VALUE;
        Integer gStart = null;
        Integer gEnd = null;

        Integer max = null;
        Integer start = null;
        Integer end = null;

        for (Integer i=0; i<A.length; ++i) {

            if (max == null && A[i]>0) {
                max = A[i];
                start = i;
                end = i;
            } else if (max != null){
                max += A[i];
                end = i;
            }

            if (max != null) {
                if (max < 0) {

                    max = null;
                    start = null;
                    end = null;

                } else if (max > gMax) {

                    gMax = max;
                    gStart = start;
                    gEnd = end;

                }
            }

        }

        System.out.print(gMax + " " + gStart + " " + gEnd);

        return gMax;
    }

}