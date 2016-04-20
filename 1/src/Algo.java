public class Algo {

    private Integer[] A = {1,4};
    private final Integer target = 5;

    public void run() {
        Integer start = 0;
        Integer stop = 0;
        Integer sumSoFar = 0;

        while (stop < A.length) {

            sumSoFar += A[stop];

            while (sumSoFar > target && start < stop) {
                sumSoFar -= A[start];
                ++start;
            }

            if (sumSoFar == target) {
                System.out.print("found at " + start + " " + stop);
            }

            ++stop;

        }
    }
}