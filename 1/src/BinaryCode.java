import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryCode {


    public void run() {

        List<Integer> A = Arrays.asList(new Integer[] {10, 20, 30});

        System.out.print(findMin(A));

    }

    private int findMin (List<Integer> A) {

        if (A.size() < 3) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;
        for (int thisIndex=0; thisIndex<A.size(); ++thisIndex) {

            if (A.size()-thisIndex > 3) {

                List<Integer> listWith = new ArrayList<>(A);
                listWith.remove((int)(thisIndex+1));
                int sumWith = A.get(thisIndex) * A.get(thisIndex+1) * A.get(thisIndex+2)
                        + findMin(listWith);


                List<Integer> listWithout = new ArrayList<>(A);
                listWithout.remove((int)(thisIndex+2));
                int sumWithout = A.get(thisIndex+1) * A.get(thisIndex+2) * A.get(thisIndex+3)
                        + findMin(listWithout);


                minCost = Math.min(minCost, Math.min(sumWith, sumWithout));
            } else if (A.size()-thisIndex == 3) {

                List<Integer> list  = new ArrayList<>(A);
                list.remove((int)(thisIndex+1));
                int thisSum = A.get(thisIndex) * A.get(thisIndex+1) * A.get(thisIndex+2)
                        + findMin(list);

                minCost = Math.min(minCost, thisSum);
            } else {
                break;
            }
        }

        return minCost;
    }

}