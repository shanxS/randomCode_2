import java.util.HashSet;
import java.util.Set;

public class BinaryCode {

    private Integer[] A = {1, 2, 3, 1, 4, 5};
    private Integer k = 3;

    public void run() {

        Set<Integer> set = new HashSet<>();
        Integer counter = 0;
        while (counter <= k && counter < A.length) {
            if (!set.add(A[counter])) {
                System.out.print("repeated " + A[counter]);
            }

            ++counter;
        }

        while (counter < A.length) {
            set.remove(A[counter-k-1]);

            if (!set.add(A[counter])) {
                System.out.print("repeated " + A[counter]);
            }

            ++counter;
        }

    }

}