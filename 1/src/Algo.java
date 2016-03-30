import java.util.*;

/**
 * @author shashaku on 29/03/16.
 */
public class Algo {
    private Integer[] A =  {10,2,6,2,6};
    private Integer target = 12;
    private HashMap<Integer, Integer> elements;


    public void run() {
        Sorter s = new Sorter();
        s.quickSort(A);

        Integer startIndex = 0;
        Integer endIndex = A.length - 1;
        Integer count = 0;
        while (startIndex < endIndex) {
            Integer sum = A[startIndex] + A[endIndex];
            if (sum == target) {
                ++count;
                ++startIndex;
                --endIndex;
            }
            else if (sum > target) {
                --endIndex;
            }
            else if (sum < target) {
                ++startIndex;
            }
        }

        System.out.print(count);
    }

    private void remove(Integer value) {
        Integer count = elements.get(value);
        elements.put(value, count - 1);
    }
}

class Sorter {
    private Stack<Integer> startIndex, endIndex;
    private Integer[] A;

    public void quickSort(Integer[] A) {
        startIndex = new Stack<Integer>();
        endIndex = new Stack<Integer>();

        startIndex.push(0);
        endIndex.push(A.length-1);
        this.A = A;

        sort();
    }

    private void sort() {
        while (startIndex.size() > 0 && endIndex.size() > 0) {
            Integer start = startIndex.pop();
            Integer end = endIndex.pop();

            if (start >= end){
                continue;
            }

            Integer pivotIndex = doSort(start, end);
            startIndex.push(start);
            endIndex.push(pivotIndex-1);

            startIndex.push(pivotIndex+1);
            endIndex.push(end);
        }
    }

    private Integer doSort(Integer start, Integer end) {
        Integer marker = start-1;
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
