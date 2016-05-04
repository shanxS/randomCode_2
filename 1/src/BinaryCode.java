import java.util.Stack;

public class BinaryCode {

    private Integer[] A = {9,1,2,5,3};

    public void run() {

        Stack<Integer> startStack = new Stack<>();
        Stack<Integer> endStack = new Stack<>();

        startStack.push(0);
        endStack.push(A.length-1);

        while (startStack.size() > 0 && endStack.size() > 0) {

            Integer start = startStack.pop();
            Integer end = endStack.pop();

            Integer pivot = qSort(start, end);
            if (pivot-1 > start) {
                startStack.push(start);
                endStack.push(pivot-1);
            }
            if (pivot+1 < end) {
                startStack.push(pivot+1);
                endStack.push(end);
            }
        }

        for (Integer ele : A) {
            System.out.print(ele + " ");
        }

    }

    private Integer qSort(Integer start, Integer end) {
        Integer marker = start-1;
        Integer pivotValue = A[end];

        for (Integer i=start; i<end; ++i) {
            if (A[i] <= pivotValue) {
                ++marker;
                swap(marker, i);
            }
        }

        swap(marker+1, end);
        return marker+1;
    }

    private void swap(Integer from, Integer to) {
        Integer tmp  = A[from];
        A[from] = A[to];
        A[to] = tmp;
    }
}