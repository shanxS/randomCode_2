import java.util.HashMap;
import java.util.Stack;

public class Algo {

    private Integer[] A = {2,3,9,4,5,6};
    private Stack<Integer> maxStack;
    private HashMap<Integer, Integer> competitor;

    public void run() {
        init();
        process();
    }

    private void process() {
        Stack<Integer> secMaxStack = new Stack<>();

        Boolean isEvenRun = true;
        while ((isEvenRun && maxStack.size() > 1)
                || (!isEvenRun && secMaxStack.size() > 1)) {

            if (isEvenRun) {

                while (maxStack.size() > 1) {
                    secMaxStack.push(compare(maxStack.pop(), maxStack.pop()));
                }

                if (maxStack.size() == 1) {
                    secMaxStack.push(maxStack.pop());
                }

            } else {

                while (secMaxStack.size() > 1) {
                    maxStack.push(compare(secMaxStack.pop(), secMaxStack.pop()));
                }

                if (secMaxStack.size() == 1) {
                    maxStack.push(secMaxStack.pop());
                }

            }


            isEvenRun = !isEvenRun;
        }

        if (isEvenRun) {
            System.out.print("max " + maxStack.peek() + " sec max " + competitor.get(maxStack.peek()));
        } else {
            System.out.print("max " + secMaxStack.peek() + " sec Max " + competitor.get(secMaxStack.peek()));
        }
    }

    private void init() {
        maxStack = new Stack<>();
        competitor = new HashMap<>();

        Integer counter = 0;
        while (counter < A.length) {

            if (counter+1 < A.length) {
                maxStack.push(compare(A[counter], A[counter+1]));
            } else {
                maxStack.push(A[counter]);
            }

            counter += 2;
        }
    }

    private Integer compare(Integer d1, Integer d2) {
        Integer big = (d1>d2) ? d1 : d2;
        Integer small = (d1>d2) ? d2 : d1;

        Integer comp = competitor.get(big);
        if (comp == null) {
            comp = Integer.MIN_VALUE;
        }
        competitor.put(big, Math.max(small, comp));

        return big;
    }

}