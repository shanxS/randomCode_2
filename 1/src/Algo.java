import java.util.*;

public class Algo {

    private Integer[] A = {2,3,9,4,5,6,1};
    private Stack<Integer> minStack;
    private HashMap<Integer, Integer> trace;


    public void run() {
        init();
        process();

    }

    private void process() {
        Stack<Integer> secMinStack = new Stack<>();

        Boolean isEvenRun = true;

        while ((isEvenRun && minStack.size() > 1)
                || (!isEvenRun && secMinStack.size() > 1)) {

            if (isEvenRun) {

                while (minStack.size() > 1) {
                    secMinStack.push( compete (minStack.pop(), minStack.pop()));
                }

                if (minStack.size() == 1) {
                    secMinStack.push(minStack.pop());
                }

            } else {

                while (secMinStack.size() > 1) {
                    minStack.push ( compete (secMinStack.pop(), secMinStack.pop()) );
                }

                if (secMinStack.size() == 1) {
                    minStack.push (secMinStack.pop());
                }

            }

            isEvenRun = !isEvenRun;

        }

        if (isEvenRun) {
            System.out.print("min " + minStack.peek() + " sec min " + trace.get(minStack.peek()));
        } else {
            System.out.print("min " + secMinStack.peek() + " sec min " + trace.get(secMinStack.peek()));
        }

    }

    private void init() {

        minStack = new Stack<>();
        trace = new HashMap();

        Integer counter = 0;
        while (counter < A.length) {

            if (counter+1 < A.length) {
                minStack.push ( compete (A[counter], A[counter+1] ) );
            } else {
                minStack.push(A[counter]);
            }

            counter += 2;
        }


    }

    private Integer compete(Integer i1, Integer i2) {
        Integer min = Math.min(i1, i2);
        Integer max = Math.max (i1, i2);

        Integer compe = trace.get(min);
        if (compe == null) {
            compe = Integer.MAX_VALUE;
        }
        trace.put (min, Math.min(compe, max));

        return min;
    }
}

