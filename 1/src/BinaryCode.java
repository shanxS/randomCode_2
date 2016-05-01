import java.util.HashSet;

public class BinaryCode {

    private Integer[] A = {4, 2, 0, 1, 6};
    private HashSet<Integer> set;

    public void run() {

        set = new HashSet<>();
        Integer sumSoFar = 0;

        for (Integer i=0; i<A.length; ++i) {
            Integer ele = A[i];

            sumSoFar += ele;
            if (set.contains(sumSoFar)) {
                searchFrom(i);
                break;
            } else {
                set.add(sumSoFar);
            }
        }

    }

    private void searchFrom(Integer index) {
        Integer end = index;
        Integer sum = A[index];
        while (sum != 0 && index >= 0) {
            --index;
            sum += A[index];
        }

        System.out.print(index + " " + end);
    }
}