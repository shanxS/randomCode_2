import java.util.ArrayList;
import java.util.List;

public class Algo {

    private Integer[] A = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};

    public void run() {

        List<Integer> list = new ArrayList<>();

        for (Integer i=0; i<A.length; ++i) {
            if (list.size() == 0) {
                list.add(A[i]);
            } else if (list.get(list.size()-1) < A[i]) {
                list.add(A[i]);
            } else {
                replace(list, A[i]);
            }
        }

        System.out.print(list + " " + list.size());
    }

    private void replace(List<Integer> list, Integer value) {

        Integer counter = list.size()-1;
        while (counter >= 0 && value < list.get(counter)) {
            --counter;
        }

        list.set(counter+1, value);
    }
}