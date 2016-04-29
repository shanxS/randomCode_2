import java.util.ArrayList;
import java.util.List;

public class BinaryCode {


    private Integer[] A = {7, 10, 4, 3, 20, 15};
    private Integer k = 3;

    public void run() {

        Heap heap = new Heap(Heap.Type.MIN);
        for (Integer ele : A) {
            if (heap.size() < k) {
                heap.insert(ele);
            } else {

                if (heap.getTop() < ele) {
                    heap.removeTop();
                    heap.insert(ele);
                }

            }

        }

        System.out.print(heap.getTop());


    }
}


class Heap {

    public static enum Type {MIN, MAX};

    private List<Integer> data;
    private boolean isMax;

    public Heap(Type type) {
        data = new ArrayList<>();
        isMax = type == Type.MAX;
    }

    public Integer size() {
        return data.size();
    }

    public void insert(Integer value) {
        data.add(value);
        heapify(data.size()-1);
    }

    public Integer getTop() {
        if (data.size() == 0) {
            return null;
        }

        return data.get(0);
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

        if (isValid(leftChildIndex) && isValid (rightChildIndex)) {

            if ((data.get(leftChildIndex) > data.get(rightChildIndex)) == isMax) {
                if ((data.get(parentIndex) > data.get(leftChildIndex)) != isMax) {
                    swap(parentIndex, leftChildIndex);
                    reverseHeapify(leftChildIndex);
                }
            } else if ((data.get(parentIndex) > data.get(rightChildIndex)) != isMax) {
                swap(parentIndex, rightChildIndex);
                reverseHeapify(rightChildIndex);
            }

        } else if (isValid(leftChildIndex)) {

            if ((data.get(parentIndex) > data.get(leftChildIndex)) != isMax) {
                swap(parentIndex, leftChildIndex);
                reverseHeapify(leftChildIndex);
            }

        } else if (isValid(rightChildIndex)) {

            if ((data.get(parentIndex) > data.get(rightChildIndex)) != isMax) {
                swap(parentIndex, rightChildIndex);
                reverseHeapify(rightChildIndex);
            }

        }

    }

    private Integer getLeftChildIndex(Integer parentIndex) {
        return (2*parentIndex) + 1;
    }

    private Integer getRightChildIndex(Integer parentIndex) {
        return getLeftChildIndex(parentIndex) + 1;
    }

    private boolean isValid(Integer index) {
        return (index >= 0) && (index < data.size());
    }


    private void heapify(Integer childIndex) {
        Integer parentIndex = getParentIndex(childIndex);

        if (childIndex == parentIndex) {
            return;
        }

        if ((data.get(parentIndex) > data.get(childIndex)) != isMax) {
            swap(parentIndex, childIndex);
            heapify(parentIndex);
        }
    }

    private Integer getParentIndex(Integer childIndex) {
        return (childIndex-1)/2;
    }

    private void swap(Integer form, Integer to) {
        Integer tmp = data.get(form);
        data.set(form, data.get(to));
        data.set(to, tmp);
    }


}