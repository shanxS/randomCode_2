public class BinaryCode {

    private int[] A = {1, 101, 2, 3, 100, 4, 5};
    private int[] sum = new int[A.length];

    public void run() {

        for (int i=0; i<A.length; ++i) {
            sum[i] = A[i];
        }

        for (int i=1; i<A.length; ++i) {
            for (int j=0; j<i; ++j) {
                if (A[j] < A[i] && sum[i] < sum[j] + A[i]) {
                    sum[i] = sum[j] + A[i];
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i=0; i<sum.length; ++i) {
            max = Math.max(max, sum[i]);
        }

        System.out.print(max);

    }
}