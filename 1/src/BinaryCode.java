public class BinaryCode {

    private Integer[] A = {100, 180, 260, 310, 40, 535, 695};

    public void run() {

        Integer maxDiff = Integer.MIN_VALUE;
        Integer minSoFar = A[0];
        for (Integer i=1; i<A.length; ++i) {
            maxDiff = Math.max(maxDiff, Math.abs(A[i] - minSoFar));
            minSoFar = Math.min(minSoFar, A[i]);
        }

        System.out.print(maxDiff);

    }
}