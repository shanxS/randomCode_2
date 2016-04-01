import java.util.ArrayDeque;

/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] A = {3,2,1,5,4};//{4,5,1,2,3};
    private Integer target = 5;

    private final Integer INC = 1;
    private final Integer DEC = -1;
    private ArrayDeque<Integer> trend;
    private ArrayDeque<Integer> trendLength;


    public void run() {

        if (A.length <= 3) {
            System.out.print("array lenght in sufficient");
        }

        trend = new ArrayDeque<>();
        trendLength = new ArrayDeque<>();

        computeTrend();
        Integer lengthSoFar = 0;
        while (trend.size()>0 && trendLength.size()>0) {
            Integer thisTrend = trend.removeLast();
            Integer thisTrendLength = trendLength.removeLast();

            if (thisTrend == INC && findInInc(lengthSoFar, lengthSoFar+thisTrendLength-1)) {
                System.out.print("found in inc");
            }
            else if (thisTrend == DEC  && findInDec(lengthSoFar, lengthSoFar+thisTrendLength-1)) {
                System.out.print("found in dec");
            }

            lengthSoFar += thisTrendLength-1;
        }
    }

    private boolean findInInc(Integer start, int end) {

        while (start <= end) {

            Integer mid = start + ((end-start)/2);
            if (A[mid] == target) {
                System.out.println("found at " + mid);
                return true;
            } else if (A[mid] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }


        return false;
    }

    private boolean findInDec(Integer start, Integer end) {

        while (start <= end) {
            Integer mid = start + ((end-start)/2);
            if (A[mid] == target) {
                System.out.println("found at " + mid);
                return true;
            } else if (A[mid] < target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return false;
    }

    private void computeTrend() {
        Integer trendSoFar = (A[0] > A[1]) ? DEC : INC;
        Integer trendLengthSoFar = 2;
        Boolean updated = false;
        for (Integer i=1; i<A.length - 1; ++i) {
            Integer thisTrend = (A[i] > A[i+1]) ? DEC : INC;

            if (thisTrend == trendSoFar) {
                ++trendLengthSoFar;
               updated = false;
            } else {
                trend.push(trendSoFar);
                trendLength.push(trendLengthSoFar);
                updated = true;

                trendSoFar = thisTrend;
                trendLengthSoFar = 2;
            }
        }

        //if (!updated)
        {
            trend.push(trendSoFar);
            trendLength.push(trendLengthSoFar);
        }
    }
}
