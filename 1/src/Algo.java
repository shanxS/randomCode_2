/**
 * @author shashaku on 29/03/16.
 */
public class Algo {
    private Integer[] A =  {-1,-1,2,2,3,3};


    public void run() {
        Integer xor = A[0];
        for (Integer i=1; i<A.length; ++i) {
            xor ^= (A[i]);
        }

            System.out.print("odd " + (xor));

    }
}
