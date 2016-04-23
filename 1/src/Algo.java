import java.util.*;

public class Algo {


    private Integer[] A = {1, 5, 11, 5};
    private Integer sum = 0, target;
    private Stack<Integer> stack = new Stack<>();

    public void run() {

        for (Integer ele : A) {
            sum += ele;
        }

        if (sum % 2 != 0) {
            System.out.print("cant divide");
            return;
        }
        target = sum/2;

        for (Integer i=0; i<A.length; ++i) {

            Integer sumSoFar = A[i];

            if (sumSoFar < target) {

                stack.push(A[i]);

                if (evaluate(sumSoFar, i)) {
                    System.out.print("found ");
                    while (stack.size() > 0) {
                        System.out.print(stack.pop() + " ");
                    }

                    return;
                } else {
                    stack.pop();
                }
            } else if (sumSoFar == target) {
                System.out.print("found " + A[i]);
            } else {
                continue;
            }

        }

    }


    private Boolean evaluate(Integer lastSumSoFar, Integer lastIndex) {

        for (Integer i=lastIndex+1; i<A.length; ++i) {
            Integer sumSoFar = A[i] + lastSumSoFar;

            if (sumSoFar < target) {
                stack.push(A[i]);

                if (evaluate(sumSoFar, i)) {
                    return true;
                } else {
                    stack.pop();
                }
            } else if (sumSoFar == target) {
                stack.push(A[i]);
                return true;
            } else {
                continue;
            }
        }

        return false;
    }

}