import java.util.Stack;

public class Algo {

    private Integer[] A = {4,5,8,3,2,7,9,1};
    private Stack<Integer> minStack, maxStack;

    public void run() {
        init();
        process();
    }

    private void process() {
        Stack<Integer> secMinStack = new Stack<>();
        Stack<Integer> secMaxStack = new Stack<>();

        Boolean isEvenRun = true;

        while ((isEvenRun && minStack.size() > 1)
                || (!isEvenRun && secMinStack.size() > 1)){


            if (isEvenRun) {

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
                    maxStack.push(Math.max(secMaxStack.pop(), secMaxStack.pop()));
                }

                if (secMinStack.size() == 1) {
                    minStack.push(secMinStack.pop());
                    maxStack.push(secMaxStack.pop());
                }

            }

            isEvenRun = !isEvenRun;

        }

        if (isEvenRun) {
            System.out.print("min " + minStack.peek() + " max " + maxStack.pop());
        } else {
            System.out.print("min " + secMinStack.peek() + " max " + secMaxStack.peek());
        }
    }

    private void init () {
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