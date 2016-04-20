public class Algo {

    private Integer[] A = {1, 4};
    private final Integer target = 6;

    public void run() {

        Integer start = 0;
        Integer stop = 0;
        Integer sumSoFar = A[stop];

        while (stop < A.length) {


            if (sumSoFar == target) {
                System.out.print("foudn at " + start + " " + stop);
                break;
            } else if (sumSoFar < target) {
                ++stop;

                if (stop < A.length) {
                    sumSoFar += A[stop];
                }

            } else {
                if (start == stop) {
                    ++start;
                    ++stop;

                    if (stop < A.length) {
                        sumSoFar = A[stop];
                    }

                } else {
                    sumSoFar -= A[start];
                    ++start;
                }
            }
        }

    }


}