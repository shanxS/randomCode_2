import java.util.*;

public class Algo {


    private Integer[] A = {5, 20, 3, 2, 50, 80};
    private Integer n = -1;

    public void run() {

        Set<Integer> set = new TreeSet<>();

        for (Integer ele : A) {

            if (ele > n) {
                boolean found = set.contains(ele-n);
                if (found) {
                    System.out.print("found " + ele + " " + (ele-n));
                }
            } else {
                boolean found = set.contains(ele+n);
                if (found) {
                    System.out.print("found " + ele + " " + (ele+n));
                }
            }

            set.add(ele);
        }
    }
}