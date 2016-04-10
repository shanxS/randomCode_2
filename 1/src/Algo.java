import java.util.Stack;

public class Algo {

    private Integer[] A = {4,5,2,3,25};

    public void run() {
        Stack<Integer> stack = new Stack<>();
        Integer[] NGE = new Integer[A.length];

        for (Integer i=A.length-1; i>=0; --i) {
            if (stack.size() == 0) {
                stack.push(A[i]);
                NGE[i] = -1;
            } else {
                while (stack.size() > 0 && stack.peek() < A[i]) {
                    stack.pop();
                }

                if (stack.size() > 0) {
                    NGE[i] = stack.peek();
                } else {
                    NGE[i] = -1;
                }
            }

            stack.push(A[i]);
        }

        for (Integer ele : NGE) {
            System.out.print(ele + "  ");
        }


    }

}