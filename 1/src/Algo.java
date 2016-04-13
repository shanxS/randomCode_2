public class Algo {

    private Integer[] A = {6, 5, 4, 3, 2, 1};

    public void run() {
        Integer[] lMinIndex = new Integer[A.length];
        Integer minMarker = 0;
        lMinIndex[minMarker] = minMarker;
        Integer minSoFarIndex = minMarker;

        Integer[] rMaxIndex = new Integer[A.length];
        Integer maxMarker = A.length-1;
        rMaxIndex[maxMarker] = maxMarker;
        Integer maxSoFarIndex = maxMarker;

        while (minMarker < A.length) {
            if (A[minSoFarIndex] > A[minMarker]) {
                minSoFarIndex = minMarker;
            }
            lMinIndex[minMarker] = minSoFarIndex;

            if (A[maxSoFarIndex] < A[maxMarker]) {
                maxSoFarIndex = maxMarker;
            }
            rMaxIndex[maxMarker] = maxSoFarIndex;

            ++minMarker;
            --maxMarker;
        }

        minMarker = 0;
        maxMarker = 0;
        Integer gap = Integer.MIN_VALUE;
        Integer start=null, end=null;
        while (minMarker < A.length && maxMarker < A.length) {
            if (A[lMinIndex[minMarker]] < A[rMaxIndex[maxMarker]]) {
                if (gap < (rMaxIndex[maxMarker] - lMinIndex[minMarker])) {
                    gap = (rMaxIndex[maxMarker] - lMinIndex[minMarker]);
                    start = lMinIndex[minMarker];
                    end = rMaxIndex[maxMarker];
                }

                ++maxMarker;
            } else {
                ++minMarker;
            }
        }

        System.out.print(start + " " + end + " " + gap);
    }
}
