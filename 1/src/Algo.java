import java.util.ArrayList;
import java.util.List;

public class Algo {

    private Integer[] A = {2, 6, 3, 12, 56, 8};
    private Integer k = 3;

    public void run() {

        Heap heap = new Heap(Heap.Type.MIN);

        Integer reader = 0;
        Integer writer = 0;
        while (reader < A.length) {
            if (heap.getSize() > k) {
                A[writer] = heap.removeTop();
                ++writer;
            }

            heap.insert(A[reader]);
            ++reader;
        }

        while (writer < A.length) {
            A[writer] = heap.removeTop();
            ++writer;
        }

        for (Integer ele : A) {
            System.out.print(ele + " ");
        }

    }
}

class Heap {
    public enum Type {MIN, MAX};

    private List<Integer> data;
    private final Boolean isMax;

    public Heap(Type type) {
        isMax = (type == Type.MAX);
        data = new ArrayList<>();

    }

    public Integer getSize() { return  data.size(); }

    public void insert(Integer value) {
        data.add(value);
        heapify(data.size()-1);

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
            } else if ((data.get(parentIndex) > data.get(rightChildIndex)) != isMax) {
                swap(parentIndex, rightChildIndex);
                reverseHeapify(rightChildIndex);
            }

        } else if (isValidIndex(leftChildIndex)) {
            if ((data.get(parentIndex) > data.get(leftChildIndex)) != isMax) {
                swap(parentIndex, leftChildIndex);
                reverseHeapify(leftChildIndex);
            }

        } else if (isValidIndex(rightChildIndex)) {
            if ((data.get(parentIndex) > data.get(rightChildIndex)) != isMax) {
                swap(rightChildIndex, parentIndex);
                reverseHeapify(rightChildIndex);
            }

        }
    }

    private Integer getRightChildIndex(Integer parentIndex) {
        return getLeftChildIndex(parentIndex) + 1;
    }

    private Integer getLeftChildIndex(Integer parentIndex) {
        return (2*parentIndex) + 1;
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
            swap(parentIndex, childIndex);
            heapify(parentIndex);
        }
    }

    private Integer getParentIndex(Integer childIndex) {
        return ((childIndex-1)/2);
    }

    private void swap(Integer from, Integer to) {
        Integer tmp = data.get(from);
        data.set(from, data.get(to));
        data.set(to, tmp);
    }


}