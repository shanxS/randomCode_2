import java.util.*;

public class Algo {


    private Integer[] A = {1, 5, 11, 5};
    private Integer sum = 0;
    private Stack<Integer> stack = new Stack<>();

    public void run() {

        for (Integer ele : A) {
            sum += ele;
        }

        if (sum % 2 != 0) {
            System.out.print("cant divide");
            return;
        }
        Integer target = sum / 2;

        if (evaluate(1, target-A[0])
                || evaluate(1, target)) {
            System.out.print("found ");
        } else {
            System.out.print("not found");
        }

    }

    private Boolean evaluate (Integer thisIndex, Integer thisTarget) {
        if (thisTarget == 0) {
            return true;
        }

        if (thisIndex >= A.length) {
            return false;
        }

        return evaluate(thisIndex+1, thisTarget-A[thisIndex])
                || evaluate(thisIndex+1, thisTarget);
    }

}