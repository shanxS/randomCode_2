import java.util.ArrayList;
import java.util.List;

public class Algo {

    private Integer[] A = {1,9,5,10,7,3};

    public void run() {
        Heap max = new Heap(Heap.Type.MIN);
        for (Integer ele : A) {
            max.insert(ele);
//            System.out.println(max.getTop());
        }

        while (max.size() > 0) {
            System.out.println(max.removeTop());
        }
    }
}

class Heap {
    public static enum Type {MIN, MAX};

    private final boolean isMax;
    private List<Integer> data;

    public Heap(Type type) {
        isMax = (type == Type.MAX);
        data = new ArrayList<>();
    }

    public Integer size() {
        return data.size();
    }

    public void insert(Integer value) {
        data.add(value);
        heapify(data.size() - 1);
    }

    public Integer removeTop() {
        if (data.size() == 0) {
            return null;
        }

        Integer result = data.get(0);
        swap(0, data.size()-1);
        data.remove(data.size()-1);
        reverseHeapify(0);

        return result;
    }

    private void reverseHeapify(Integer parentIndex) {
        Integer leftChildIndex = getLeftChildIndex(parentIndex);
        Integer rightChildIndex = getRightChildIndex(parentIndex);

        if (isValidIndex(leftChildIndex) && isValidIndex(rightChildIndex)) {
            if ((data.get(leftChildIndex) > data.get(rightChildIndex)) == isMax) {
                if ((data.get(parentIndex) > data.get(leftChildIndex)) != isMax) {
                    swap(parentIndex, leftChildIndex);
                    reverseHeapify(leftChildIndex);
                }
            } else {
                if ((data.get(parentIndex) > data.get(rightChildIndex)) != isMax ) {
                    swap(parentIndex, rightChildIndex);
                    reverseHeapify(rightChildIndex);
                }
            }

        } else if (isValidIndex(leftChildIndex)) {
            if ((data.get(parentIndex) > data.get(leftChildIndex)) != isMax) {
                swap(parentIndex, leftChildIndex);
                reverseHeapify(leftChildIndex);
            }

        } else if (isValidIndex(rightChildIndex)) {
            if ((data.get(parentIndex) > data.get(rightChildIndex)) != isMax ) {
                swap(parentIndex, rightChildIndex);
                reverseHeapify(rightChildIndex);
            }
        }
    }

    private Integer getRightChildIndex(Integer index) {
        return getLeftChildIndex(index) + 1;
    }

    private Integer getLeftChildIndex(Integer index) {
        return ((2*index) + 1);
    }

    private boolean isValidIndex(Integer index) {
        return (index >= 0) && (index < data.size());
    }

    private void heapify(Integer childIndex) {
        Integer parentIndex = getParentIndex(childIndex);

        if (parentIndex == childIndex) {
            return;
        }

        if ((data.get(parentIndex) > data.get(childIndex)) != isMax) {
            swap (parentIndex, childIndex);
            heapify(parentIndex);
        }
    }

    private void swap(Integer parentIndex, Integer childIndex) {
        Integer tmp = data.get(parentIndex);
        data.set(parentIndex, data.get(childIndex));
        data.set(childIndex, tmp);
    }

    private Integer getParentIndex(Integer childIndex) {
        return ((childIndex-1)/2);
    }
}