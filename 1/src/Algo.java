import java.util.*;

/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] A = {25,5,10,100,10,5};//{1, 2, 3, 6};
    private HashMap<Integer, Integer> positionMax = new HashMap<>();
    private Integer globalMax = Integer.MIN_VALUE;


    public void run() {
        positionMax.put(A.length-1, A[A.length-1]);
        positionMax.put(A.length-2, A[A.length-2]);
        positionMax.put(A.length-3, A[A.length-3] + A[A.length-1]);

        for (Integer i=A.length-4; i>=0; --i) {

            Integer thisMax = A[i] + Math.max(positionMax.get(i+2), positionMax.get(i+3));
            positionMax.put(i, thisMax);
        }

        System.out.print(positionMax);
    }
}