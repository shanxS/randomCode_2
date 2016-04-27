import java.util.HashSet;
import java.util.Set;

public class BinaryCode {

    private Integer[] A = {1, 2, 3, 4, 4};
    private Integer k = 3;
    public void run() {

        Set<Integer> set = new HashSet<>();
        Integer counter = 0;
        while (counter <= k && counter < A.length) {
            Integer ele = A[counter];
            if (!set.add(ele)) {
                System.out.println("repeated " + ele);
            }

            ++counter;
        }


        while (counter < A.length) {
            set.remove(A[counter-k-1]);

            Integer ele = A[counter];
            if (!set.add(ele)) {
                System.out.println("repeated " + ele);
            }

            ++counter;
        }

    }

}