import java.util.HashMap;
import java.util.Stack;

public class Algo {

    private Integer[] A = {2,3,9,4,5,6};
    private Stack<Integer> maxStack;
    private HashMap<Integer, Integer> compe;

    public void run() {
        init();
        process();


    }

    private void process() {
        Stack<Integer> secMaxInteger = new Stack<>();

        Boolean isEvenRun = true;

        while ((isEvenRun && maxStack.size() > 1)
                || (!isEvenRun && secMaxInteger.size() > 1)) {

            if (isEvenRun) {

                while (maxStack.size() > 1) {
                    secMaxInteger.push(compete(maxStack.pop(), maxStack.pop()));
                }

                if (maxStack.size() == 1) {
                    secMaxInteger.push(maxStack.pop());
                }

            } else {

                while (secMaxInteger.size() > 1) {
                    maxStack.push(compete(secMaxInteger.pop(), secMaxInteger.pop()));
                }

                if (secMaxInteger.size() == 1) {
                    maxStack.push(secMaxInteger.pop());
                }

            }

            isEvenRun = !isEvenRun;

        }

        if (isEvenRun) {
            System.out.print("max " + maxStack.peek() + " sec max " + compe.get(maxStack.peek()));
        } else {
            System.out.print("max " + secMaxInteger.peek() + " sec max " + compe.get(secMaxInteger.peek()));
        }
    }

    private void init() {
        maxStack = new Stack<>();
        compe = new HashMap<>();

        Integer counter = 0;
        while (counter < A.length) {
            if (counter+1  < A.length) {
                maxStack.push(compete(A[counter], A[counter+1]));
            } else {
                maxStack.push(A[counter]);
            }

            counter += 2;
        }
    }

    private Integer compete(Integer d1, Integer d2) {
        Integer big = (d1 > d2) ? d1 : d2;
        Integer small = (d1 < d2) ? d1 : d2;

        Integer comp = compe.get(big);
        if (comp == null) {
            comp = Integer.MIN_VALUE;
        }
        compe.put(big, Math.max(comp, small));

        return big;
    }
}

