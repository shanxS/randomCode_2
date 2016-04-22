public class Algo {

    private Integer[] A = {1, 2, 3, 4};

    public void run() {

        Integer[] min = new Integer[A.length];
        Integer minSoFar = Integer.MAX_VALUE;

        Integer[] sMin = new Integer[A.length];
        Integer sMinSoFar = Integer.MAX_VALUE;

        for (Integer i=0; i<A.length; ++i) {

            if (minSoFar > A[i]) {
                sMinSoFar = minSoFar;
                minSoFar = A[i];
            } else if (sMinSoFar > A[i]) {
                sMinSoFar = A[i];
            }

            sMin[i] = sMinSoFar;
            min[i] = minSoFar;

        }


        Integer[] max = new Integer[A.length];
        Integer maxSoFar = Integer.MIN_VALUE;
        for (Integer i=A.length-1; i>=0; --i) {
            maxSoFar = Math.max(maxSoFar, A[i]);
            max[i] = maxSoFar;
        }

        for (Integer i=0; i<A.length; ++i) {
            if (A[i] != min[i] && A[i] != sMin[i] && A[i] != max[i]) {
                System.out.println(min[i] + " " + sMin[i] + " " + A[i] + " " + max[i]);
            }
        }

    }
}