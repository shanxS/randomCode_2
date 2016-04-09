/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] A = {10, 3, 5, 6, 2};

    public void run() {
        Integer[] res = new Integer[A.length];
        Integer temp = 1;

        for (Integer i=1; i<A.length; ++i) {
            temp *= A[i-1];
            res[i] = temp;
        }

        temp = 1;
        res[0] = 1;
        for (Integer i=A.length-2; i>=0; --i) {
            temp *= A[i+1];
            res[i] *= temp;
        }

        for (Integer ele : res) {
            System.out.print(ele + " ");
        }
    }
}
