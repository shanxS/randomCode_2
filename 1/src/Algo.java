public class Algo {

    private Integer[] A = {6, 5, 4, 3, 2, 1};

    public void run() {

        Integer[] min = new Integer[A.length];
        Integer minSoFar = Integer.MAX_VALUE;
        Integer[] max = new Integer[A.length];
        Integer maxSoFar = Integer.MIN_VALUE;


        Integer fwd = 0;
        Integer rev = A.length - 1;
        while (fwd < A.length && rev >= 0) {
            minSoFar = Math.min(minSoFar, A[fwd]);
            min[fwd] = minSoFar;

            maxSoFar = Math.max(maxSoFar, A[rev]);
            max[rev] = maxSoFar;

            ++fwd;
            --rev;
        }


        Integer i=0, j=0;
        Integer globalI = null, globalJ = null, maxDiff = Integer.MIN_VALUE;
        while (j<A.length) {

            if (min[i] < max[j]) {

                if (maxDiff < (j-i)) {
                    maxDiff = j-i;
                    globalI = i;
                    globalJ = j;
                }

                ++j;

            } else if (min[i] >= max[j] && i<j) {
                ++i;
            } else {
                ++j;
            }

        }

        System.out.print(maxDiff + " " + globalI + " " + globalJ);

    }
}