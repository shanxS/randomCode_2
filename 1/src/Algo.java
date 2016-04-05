import java.util.ArrayList;
import java.util.List;

/**
 * @author shashaku on 29/03/16.
 */
public class Algo {
    private Integer[] A = {6, 5, 3, 1, 8, 7, 2, 4};
    public void run() {

        MaxHeap maxHeap = new MaxHeap();

        for (Integer ele : A){
            maxHeap.put(ele);
        }

        while (maxHeap.size() > 0) {
            System.out.print(maxHeap.getMax() + " ");
        }

    }
}


class MaxHeap {
    private List<Integer> data;

    public MaxHeap() {
        data = new ArrayList<>();
    }

    public void put(Integer value) {
        data.add(value);
        heapify(data.size()-1);
    }

    public Integer getMax() {
        if (data.size() == 0) {
            return null;
        }

        Integer maxValue = data.get(0);
        swap(0, data.size()-1);
        data.remove(data.size()-1);
        reverseHeapify(0);

        return maxValue;
    }

    private void reverseHeapify(Integer parentIndex) {
        Integer leftChildIndex = leftChildOf(parentIndex);
        Integer rightChildIndex = rightChildOf(parentIndex);

        if (isValid(leftChildIndex) && isValid(rightChildIndex)) {
            if (data.get(leftChildIndex) > data.get(rightChildIndex)
                    && data.get(leftChildIndex) > data.get(parentIndex)) {
                swap(leftChildIndex, parentIndex);
                reverseHeapify(leftChildIndex);
            } else if (data.get(rightChildIndex) > data.get(parentIndex)) {
                swap(rightChildIndex, parentIndex);
                reverseHeapify(rightChildIndex);
            }

        } else if (isValid(leftChildIndex) && data.get(leftChildIndex) > data.get(parentIndex)) {
            swap(leftChildIndex, parentIndex);
            reverseHeapify(leftChildIndex);

        } else if (isValid(rightChildIndex) && data.get(rightChildIndex) > data.get(parentIndex)) {
            swap(rightChildIndex, parentIndex);
            reverseHeapify(rightChildIndex);

        }
    }

    private void heapify(Integer childIndex) {
        Integer parentIndex = parentOf(childIndex);

        if (parentIndex == childIndex || !isValid(parentIndex) || data.get(parentIndex) > data.get(childIndex)) {
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


    private Integer leftChildOf (Integer parent) {
        return (2*parent) + 1;
    }

    private Integer rightChildOf (Integer parent) {
        return leftChildOf(parent) + 1;
    }

    private Integer parentOf (Integer child) {
        return (child-1)/2;
    }

    private Boolean isValid (Integer index) {
        return (index >= 0) && (index < data.size());
    }

    public Integer size() {
        return data.size();
    }
}
