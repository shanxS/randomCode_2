import java.util.ArrayList;
import java.util.List;

public class BinaryCode {

    private Integer[] A = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};

    public void run() {
        List<Integer> data = new ArrayList<>();

        for (Integer i=0; i<A.length; ++i) {

            if (i==0) {
                data.add(A[i]);
            } else if (data.get(data.size()-1) < A[i]) {
                data.add(A[i]);
            } else {
                replace(data, A[i]);
            }

        }

        System.out.print(data.size() + " --- " + data);
    }

    private void replace(List<Integer> data, Integer value) {
        Integer counter = data.size()-1;
        while (counter >=0 && data.get(counter) > value) {
            --counter;
        }

        data.set(counter+1, value);
    }
}