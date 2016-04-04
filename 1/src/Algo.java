/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private final Integer MIN = 0;
    private final Integer MAX = 1;
    private Integer[] A = {1000, 11, 445, 1, 330, 3000};

    public void run() {

        Integer[] values = findMinMax(0, A.length-1);
        System.out.print(values[MIN] + " " + values[MAX]);
    }

    private Integer[] findMinMax(Integer start, Integer end) {
        Integer[] values = new Integer[2];

        if (end-start == 0) {
            values[MIN] = A[end];
            values[MAX] = A[end];
        } else if (end-start== 1) {
            values[MIN] = Math.min(A[start], A[end]);
            values[MAX] = Math.max(A[start], A[end]);
        } else {
            Integer mid = Math.min(start, end) + ((Math.abs(end-start))/2);
            Integer[] values1 = findMinMax(start, mid);
            Integer[] values2 = findMinMax(mid+1, end);

            values[MIN] = Math.min(values1[MIN], values2[MIN]);
            values[MAX] = Math.max(values1[MAX], values2[MAX]);
        }

        return values;
    }

}