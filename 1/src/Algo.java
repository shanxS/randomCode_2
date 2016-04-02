/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] A = {16, 17, 4, 3, 5, 2};

    public void run() {
        Integer maxSoFar = A[A.length-1];

        for (Integer i=A.length-2; i>=0; --i) {
            if (A[i] > maxSoFar) {
                maxSoFar = A[i];
                System.out.print(maxSoFar + " ");
            }
        }
    }
}