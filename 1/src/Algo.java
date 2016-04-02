import java.util.*;

/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] A = {25,20,100};//{25, 100, 10};//{25,5};//{25,5,10,100,10,5,50};//{1, 2, 3, 6};
    private HashMap<Integer, Integer> positionMax = new HashMap<>();
    private Integer globalMax = Integer.MIN_VALUE;


    public void run() {

        if (A.length == 2) {
            System.out.print(Math.max(A[0], A[1]));
        } else if (A.length == 3) {
            System.out.print(Math.max((A[0] + A[2]), A[1]));
        } else {
            positionMax.put(0, A[0]);
            positionMax.put(1, A[1]);
            positionMax.put(2, A[2] + A[1]);

            for (Integer i = 3; i < A.length; ++i) {

                Integer thisMax = A[i] + Math.max(positionMax.get(i - 2), positionMax.get(i - 3));
                positionMax.put(i, thisMax);
            }

            System.out.print(Math.max(positionMax.get(A.length-1), positionMax.get(A.length-2)));
        }
    }
}