public class Algo {

    private Integer[] A = {1, 2, 3, 4, 5, 6};

    public void run() {
        Integer[] lMin = new Integer[A.length];
        lMin[0] = A[0];
        Integer minMarker = 1;

        Integer[] rMax = new Integer[A.length];
        rMax[A.length-1] = A[A.length-1];
        Integer maxMarker = A.length - 2;

        while (minMarker < A.length) {
            lMin[minMarker] = Math.min(lMin[minMarker-1], A[minMarker]);
            ++minMarker;

            rMax[maxMarker] = Math.max(rMax[maxMarker+1], A[maxMarker]);
            --maxMarker;
        }

        minMarker = 0;
        maxMarker = 0;
        Integer gap = Integer.MIN_VALUE, start = null, end = null;
        while (minMarker < A.length && maxMarker < A.length) {
            if (lMin[minMarker] < rMax[maxMarker]) {
                if (gap < (maxMarker - minMarker)) {
                    gap = maxMarker - minMarker;
                    start = minMarker;
                    end = maxMarker;
                }

                ++maxMarker;
            } else {
                ++minMarker;
            }
        }

        System.out.print(start + " " + end + " " + gap);

    }
}
