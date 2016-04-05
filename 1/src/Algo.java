import java.util.ArrayList;
import java.util.List;

/**
 * @author shashaku on 29/03/16.
 */
public class Algo {
    private Integer[] A = {6, 5, 3, 1, 8, 7, 2, 4};
    private Integer k = 3;
    public void run() {

        MinHeap minHeap= new MinHeap();

        for (Integer ele : A){
            minHeap.add(ele);
        }

        while (minHeap.size() > 0) {
            System.out.print(minHeap.getMin() + " ");
        }

    }
}

class MinHeap {
    private List<Integer> data;

    public MinHeap() {
        data = new ArrayList<>();
    }

    public void add(Integer value) {
        data.add(value);
        heapify(data.size()-1);

    }

    public Integer size() {
        return data.size();
    }

    public Integer getMin() {
        if (data.size() == 0) {
            return null;
        }

        Integer minValue = data.get(0);
        swap(0, data.size()-1);
        data.remove(data.size()-1);
        reverseHeapify(0);


        return minValue;
    }

    private void reverseHeapify(Integer parentIndex) {
        Integer leftChildIndex = leftChildOf(parentIndex);
        Integer rightChildIndex = rightChildOf(parentIndex);

        if (isValid(leftChildIndex) && isValid(rightChildIndex)) {
            if (data.get(leftChildIndex) < data.get(rightChildIndex)
                    && data.get(leftChildIndex) < data.get(parentIndex)) {
                swap(leftChildIndex, parentIndex);
                reverseHeapify(leftChildIndex);
            } else if (data.get(rightChildIndex) < data.get(parentIndex)) {
                swap(rightChildIndex, parentIndex);
                reverseHeapify(rightChildIndex);

            }

        } else if (isValid(leftChildIndex) && data.get(leftChildIndex) < data.get(parentIndex)) {
            swap(leftChildIndex, parentIndex);
            reverseHeapify(leftChildIndex);

        } else if (isValid(rightChildIndex) && data.get(rightChildIndex) < data.get(parentIndex)) {
            swap(rightChildIndex, parentIndex);
            reverseHeapify(rightChildIndex);
        }
    }

    private void heapify(Integer childIndex) {
        Integer parentIndex = parentOf(childIndex);

        if (parentIndex == childIndex || data.get(parentIndex) < data.get(childIndex)) {
            return;
        }

        swap(parentIndex, childIndex);
        heapify(parentIndex);
    }

    private void swap(Integer from, Integer to) {
        Integer temp = data.get(from);
        data.set(from, data.get(to));
        data.set(to, temp);

    }

    private Boolean isValid (Integer index) {
        return (index >= 0) && (index < data.size());
    }

    private Integer leftChildOf(Integer parentIndex) {
        return (2*parentIndex) + 1;
    }

    private Integer rightChildOf(Integer parentIndex) {
        return leftChildOf(parentIndex) + 1;
    }

    private Integer parentOf(Integer childIndex) {
        return (childIndex-1)/2;
    }
}