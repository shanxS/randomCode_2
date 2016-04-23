import java.util.*;

public class Algo {


    private Integer[] A = {16, 17, 4, 3, 5, 2};

    public void run() {

        Integer max=A[A.length-1];
        A[A.length-1] = -1;
        for (Integer i=A.length-2; i>=0; --i) {
            max = Math.max(max, A[i]);
            A[i] = max;
        }

        for (Integer ele : A) {
            System.out.print(ele + " ");
        }

    }
}