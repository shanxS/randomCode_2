/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] A = {12, 13, 1, 10, 34, 1};

    public void run() {

        Integer small = Integer.MAX_VALUE;
        Integer small2 = Integer.MAX_VALUE;

        for (Integer i=0; i<A.length; ++i) {
            if (A[i] < small) {
                small2 = small;
                small = A[i];
            } else if (A[i] < small2 && A[i] != small) {
                small2 = A[i];
            }
        }

        System.out.print(small + " " + small2);

    }
}