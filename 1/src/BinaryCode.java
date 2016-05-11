public class BinaryCode {

    private int[] A = {-2, -5, 6, -2, -3, 1, 5, -6};

    public void run() {
        System.out.print(findMaxIn(0, A.length-1));
    }

    private int findMaxIn(int start, int end) {
        if (start > end) {
            return Integer.MIN_VALUE;
        }

        if (start == end) {
            return A[start];
        }

        int mid = Math.min(start, end) + ((Math.abs(start-end))/2);
        int rightMax = findMaxIn(start, mid);
        int leftMax = findMaxIn(mid+1, end);
        int midMax = findMinMax(start, mid, end);

        return Math.max(midMax, Math.max(rightMax, leftMax));
    }

    private int findMinMax(int start, int mid, int end) {
        int sum = 0;
        int leftSum = 0;
        for (int i=mid; i>=start; --i) {
            sum += A[i];
            leftSum = Math.max(leftSum, sum);
        }

        sum = 0;
        int rightSum = 0;
        for (int i=mid+1; i<=end; ++i) {
            sum += A[i];
            rightSum = Math.max(sum, rightSum);
        }

        return leftSum + rightSum;
    }
}