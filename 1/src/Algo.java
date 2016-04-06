/**
 * @author shashaku on 29/03/16.
 */
public class Algo {
    private Integer[] A = {7, 9, 5, 6, 3, 2 };//{2, 3, 10, 6, 4, 8, 1};

    public void run() {
        Integer maxDiff = Integer.MIN_VALUE;
        Integer maxValue = A[A.length-1];

        for (Integer j=A.length-2; j>=0; --j) {
            if (A[j] > maxValue) {
                maxValue = A[j];
            } else if (maxValue - A[j] > maxDiff) {
                maxDiff = maxValue - A[j];
            }
        }

        System.out.print(maxDiff + " " + maxValue);

    }
}
