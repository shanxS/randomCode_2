import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryCode {

    private Integer[] A = {1,2,3,4,5};
    private Integer k = 3;

    public void run() {

        for (List<Integer> list : performFor(0)) {
            System.out.println(list);
        }

    }

    private List<List<Integer>> performFor(Integer start) {
        List<List<Integer>> lists = new ArrayList<>();
        if (start >= A.length) {
            return lists;
        }

        if ((start+1) >= k) {
            lists.add(Arrays.asList(new Integer[] {A[start]}));
        }

        List<List<Integer>> subLists = performFor(start+1);
        for (List<Integer> list : subLists) {
            if (k == list.size()) {
                lists.add(list);
            } else if ((start+1) >= (k - list.size())) {
                if (start > 0) {
                    lists.add(list);
                }

                List<Integer> thisList = new ArrayList<>(list);
                thisList.add(A[start]);
                lists.add(thisList);
            }
        }



        return lists;
    }

}