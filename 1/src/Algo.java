import java.util.ArrayList;
import java.util.List;

/**
 * @author shashaku on 29/03/16.
 */
public class Algo {
    private Integer[] A = {6, 5, 3, 1, 8, 7, 2, 4};
    public void run() {
        MaxHeap maxHeap = new MaxHeap();
        for (Integer ele : A) {
            maxHeap.insert(ele);
        }

        maxHeap.print();
    }
}

class MaxHeap {
    private List<Integer> data;

    public MaxHeap() {
        data = new ArrayList<>();
    }

    public void insert(Integer value) {
        data.add(value);
        heapify(data.size()-1);
    }

    public void print() {
        print(0);
    }

    private void print(Integer parent) {
        if (!isValid(parent)) {
            return;
        }

        Integer leftChildIndex = leftChildOf(parent);
        Integer rightChildIndex = rightChildOf(parent);

        System.out.print(data.get(parent) + " - ");
        if (isValid(leftChildIndex)) {
            System.out.print(data.get(leftChildIndex));
        }
        System.out.print(", ");
        if (isValid(rightChildIndex)) {
            System.out.print(data.get(rightChildIndex));
        }
        System.out.println();

        print(leftChildIndex);
        print(rightChildIndex);
    }

    private void heapify(Integer childIndex) {
        Integer parentIndex = parentOf(childIndex);
        if (parentIndex == childIndex || !isValid(parentIndex) || data.get(parentIndex) > data.get(childIndex)) {
            return;
        }

        Integer temp = data.get(childIndex);
        data.set(childIndex, data.get(parentIndex));
        data.set(parentIndex, temp);

        heapify(parentIndex);
    }

    private Integer leftChildOf(Integer parent) {
        return (2*parent) + 1;
    }

    private Integer rightChildOf(Integer parent) {
        return leftChildOf(parent) + 1;
    }

    private Integer parentOf(Integer child) {
        return ((child - 1) / 2);
    }

    private boolean isValid(Integer index) {
        return (index >= 0) && (index < data.size());
    }
}