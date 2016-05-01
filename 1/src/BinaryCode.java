public class BinaryCode {

    private Integer[] A = {1, 4, 45, 6, 0, 19};
    private Integer target = 51;

    public void run() {
        Integer sumSoFar = 0;
        Integer start = 0;
        Integer end = 0;
        Integer minLen = Integer.MAX_VALUE;

        while (start <= end && end < A.length) {

            if (sumSoFar <= target) {
                sumSoFar += A[end];
                ++end;
            } else if (sumSoFar > target) {

                while (sumSoFar > target && start <= end) {
                    minLen = Math.min(end - start, minLen);
                    sumSoFar -= A[start];
                    ++start;
                }
            }

        }

        while (sumSoFar > target && start <= end) {
            minLen = Math.min(end - start + 1, minLen);
            sumSoFar -= A[start];
            ++start;
        }

        System.out.print(minLen);

    }
}