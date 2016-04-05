import java.util.ArrayList;
import java.util.List;

/**
 * @author shashaku on 29/03/16.
 */
public class Algo {
    private Integer[] A = {6, 5, 3, 1, 8, 7, 2, 4};
    private Integer k = 4;//3;
    public void run() {

        Heap minHeap= new Heap(Heap.Type.MIN);

        for (Integer ele : A){
            minHeap.add(ele);
        }

        while (minHeap.getSize() > 0) {
            System.out.print(minHeap.getTop() + " ");
        }

    }
}

class Heap {
    public static enum Type {MIN, MAX};

    private Boolean type; // true for max
    private List<Integer> data;

    public Heap(Type type) {
        data = new ArrayList<>();
        this.type = (type==Type.MAX);
    }

    public void add (Integer value) {
        data.add(value);
        heapify(data.size()-1);
    }

    public Integer getSize() {
        return data.size();
    }

    public Integer getTop() {
        if (data.size() == 0) {
            return null;
        }

        Integer top = data.get(0);
        swap(0, data.size()-1);
        data.remove(data.size()-1);
        reverseHeapify(0);


        return top;
    }

    private void reverseHeapify(Integer parentIndex) {
        Integer leftChildIndex = leftChildOf(parentIndex);
        Integer rightChildIndex = rightChildOf(parentIndex);

        if (isValid(leftChildIndex) && isValid(rightChildIndex)) {
            if ((data.get(leftChildIndex) > data.get(rightChildIndex)) == type
                    && (data.get(leftChildIndex) > data.get(parentIndex) == type)) {
                swap(leftChildIndex, parentIndex);
                reverseHeapify(leftChildIndex);
            } else if ((data.get(rightChildIndex) > data.get(parentIndex)) == type) {
                swap(rightChildIndex, parentIndex);
                reverseHeapify(rightChildIndex);
            }
        } else if (isValid(leftChildIndex) && (data.get(leftChildIndex) > data.get(parentIndex) == type)) {
            swap(leftChildIndex, parentIndex);
            reverseHeapify(leftChildIndex);

        } else if (isValid(rightChildIndex) && (data.get(rightChildIndex) > data.get(parentIndex)) == type) {
            swap(rightChildIndex, parentIndex);
            reverseHeapify(rightChildIndex);
        }
    }

    private void heapify(Integer childIndex) {
        Integer parentIndex = parentOf(childIndex);

        if (parentIndex == childIndex || (data.get(parentIndex) > data.get(childIndex)) == type) {
            return;
        }

        swap(parentIndex, childIndex);
        heapify(parentIndex);
    }

    private void swap(Integer from, Integer to) {
        Integer temp = data.get(to);
        data.set(to, data.get(from));
        data.set(from,temp);
    }

    private Integer leftChildOf (Integer parentIndex) {
        return (2*parentIndex) + 1;
    }

    private Integer rightChildOf (Integer parentIndex) {
        return leftChildOf(parentIndex) + 1;
    }

    private Integer parentOf (Integer childIndex) {
        return (childIndex-1)/2;
    }

    private Boolean isValid(Integer index) {
        return (index >= 0) && (index < data.size());
    }
}