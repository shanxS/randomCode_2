public class BinaryCode {

    private int[] A = {1, 101, 2, 3, 100, 4, 5};
    private int MAX = Integer.MIN_VALUE;


    public void run() {

        compute(Integer.MIN_VALUE, 0, 0);
        System.out.print(MAX);

    }

    private void compute(int prevValue, int thisIndex, int sumSoFar) {
        if (thisIndex >= A.length) {
            MAX = Math.max(MAX, sumSoFar);
            return;
        }

        if (A[thisIndex] >= prevValue) {
            compute(A[thisIndex], thisIndex+1, sumSoFar+A[thisIndex]);
        } else {
            compute(A[thisIndex], thisIndex+1, A[thisIndex]);
        }

        compute(prevValue, thisIndex+1, sumSoFar);
    }

}