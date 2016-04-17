import java.util.Stack;

public class Algo {

    private Integer[] A = {4,5,8,1,3,2,7,9};
    private Stack<Integer> minStack, maxStack;


    public void run() {
        init();
        process();

    }

    private void process() {
        Stack<Integer> secMinStack = new Stack<>();
        Stack<Integer> secMaxStack = new Stack<>();

        Boolean evenRun = true;

        while ((evenRun && minStack.size() > 1)
                || (!evenRun && secMinStack.size() > 1)) {

            if (evenRun) {

                while (minStack.size() > 1) {
                    secMinStack.push(Math.min(minStack.pop(), minStack.pop()));
                    secMaxStack.push(Math.max(maxStack.pop(), maxStack.pop()));
                }
                if (minStack.size() == 1) {
                    secMinStack.push(minStack.pop());
                    secMaxStack.push(maxStack.pop());
                }

            } else {

                while (secMinStack.size() > 1) {
                    minStack.push(Math.min(secMinStack.pop(), secMinStack.pop()));
                    maxStack.push(Math.max(secMaxStack.pop(), secMaxStack.peek()));
                }

                if (secMinStack.size() == 1) {
                    minStack.push(secMaxStack.pop());
                    maxStack.push(secMaxStack.pop());
                }
            }

            evenRun = !evenRun;
        }

        if (evenRun) {
            System.out.print("min " + minStack.peek() + " max " + maxStack.peek());
        } else {
            System.out.print("min " + secMinStack.peek() + " max " + secMaxStack.peek());
        }
    }

    private void init() {
        minStack = new Stack<>();
        maxStack = new Stack<>();

        Integer counter = 0;

        while (counter < A.length) {
            if (counter+1 < A.length) {
                minStack.push(Math.min(A[counter], A[counter+1]));
                maxStack.push(Math.max(A[counter], A[counter+1]));
            } else {
                minStack.push(A[counter]);
                maxStack.push(A[counter]);
            }

            counter += 2;
        }
    }
}