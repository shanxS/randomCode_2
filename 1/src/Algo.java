public class Algo {

    private Integer[] A = {1, 101, 2, 3, 100, 4, 5};

    public void run() {

        Integer maxSum = Integer.MIN_VALUE;
        Integer[] sums = new Integer[A.length];

        for (Integer i=A.length-1; i>=0; --i) {

            sums[i] = A[i];

            for (Integer j=A.length-1; j>i; --j) {
                if (A[j] > A[i] && sums[j] + A[i] > sums[i]) {
                    sums[i] = A[i] + sums[j];
                }
            }

            maxSum = Math.max(sums[i], maxSum);

        }

        System.out.print(maxSum);


    }
}