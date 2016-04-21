public class Algo {

    private Integer[] A = {4, 3, 2, 1};

    public void run() {

        Integer[] min =  new Integer[A.length];
        Integer minSoFar = Integer.MAX_VALUE;
        Integer[] max = new Integer[A.length];
        Integer maxSoFar = Integer.MIN_VALUE;

        Integer fwd = 0, rwd = A.length-1;
        while (fwd < A.length && rwd >= 0) {

            min[fwd] = Math.min(A[fwd], minSoFar);
            minSoFar = min[fwd];

            max[rwd] = Math.max(A[rwd], maxSoFar);
            maxSoFar = max[rwd];

            ++fwd;
            --rwd;
        }

        for (Integer i=0; i<A.length; ++i) {
            if (A[i] != min[i] && A[i] != max[i]) {
                System.out.println(min[i] + " " + A[i] + " " + max[i]);
            }
        }

   }
}