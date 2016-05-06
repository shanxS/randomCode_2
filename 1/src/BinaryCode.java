import java.util.ArrayList;
import java.util.List;

public class BinaryCode {

    private Integer[] A = {1,2,3,4,5};
    private Integer k = 3;
    List<List<Integer>> combinations;

    public void run() {

        combinations = new ArrayList<>();

        for (List<Integer> list : performFor(0)) {
            if (list.size() == k) {
                System.out.println(list);
            }
        }

    }

    private List<List<Integer>> performFor(Integer start) {

        if (start == A.length-1) {
            List<List<Integer>> lists = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            list.add(A[start]);
            lists.add(list);

            return lists;
        }

        List<List<Integer>> lists = new ArrayList<>();

        Integer thisValue = A[start];
        List<Integer> thisList = new ArrayList<>();
        thisList.add(thisValue);
        lists.add(thisList);

        for (Integer i= start+1; i<A.length; ++i) {
            List<List<Integer>> subLists = performFor(i);
            for (List<Integer> subList : subLists) {
                if (subList.size() < k) {
                    subList.add(thisValue);
                }
            }

            lists.addAll(subLists);
        }

        return lists;

    }
}