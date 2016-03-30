import java.util.*;

/**
 * @author shashaku on 29/03/16.
 */
public class Algo {
    private Integer[] A = {3,7,8,5,2,1,9,5,4};//{2,3,8,6,7};
    private Stack<Integer> startStack, endStack;

    public void run() {
        for (Integer i : A) {
            System.out.print(i + " ");
        }
        System.out.println();

        startStack = new Stack<Integer>();
        endStack = new Stack<Integer>();

        startStack.push(0);
        endStack.push(A.length - 1);
        quickSort();

        for (Integer i : A) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private void quickSort() {
        while (startStack.size() > 0 && endStack.size() > 0){
            Integer start = startStack.pop();
            Integer end = endStack.pop();

            if (start >= end) {
                continue;
            }

            Integer pivotIndex = sort(start, end);
            startStack.push(start);
            endStack.push(pivotIndex - 1);

            startStack.push(pivotIndex + 1);
            endStack.push(end);
        }
    }

    private Integer sort(Integer start, Integer end) {
        Integer marker = start - 1;
        Integer pivotValue = A[end];

        for (Integer j=start; j<end; ++j) {
            if (A[j] <= pivotValue) {
                ++marker;
                swap(marker, j);
            }
        }

        swap(marker+1, end);
        return marker+1;
    }

    private void swap(Integer from, Integer to) {
        Integer temp = A[from];
        A[from] = A[to];
        A[to] = temp;
    }



}
