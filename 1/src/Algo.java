import java.util.ArrayList;
import java.util.List;

public class Algo {

    private Integer[] A = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
    private Heap minHeap, maxHeap;

    public void run() {

        minHeap = new Heap(Heap.Type.MIN);
        maxHeap = new Heap(Heap.Type.MAX);

        for (Integer ele : A) {
            process (ele);
            System.out.print(fetchMedian() + " ");
        }

    }

    private Integer fetchMedian() {
        if (minHeap.size() == 1 && maxHeap.size() == 0) {
            return minHeap.getTop();
        } else if (minHeap.size() == maxHeap.size()) {
            return average(minHeap.getTop(), maxHeap.getTop());
        } else if (minHeap.size() > maxHeap.size()) {
            return minHeap.getTop();
        } else { //if (minHeap.size() < maxHeap.size()) {
            return maxHeap.getTop();
        }
    }

    private Integer average(Integer num1, Integer num2) {
        return Math.min(num1, num2) + ((Math.abs(num1-num2))/2);
    }

    private void process(Integer ele) {
        if (minHeap.size() == 0) {
            minHeap.insert(ele);
        } else {
            if (minHeap.size() == maxHeap.size()) {

                if (ele > minHeap.getTop()) {
                    minHeap.insert(ele);
                } else {
                    maxHeap.insert(ele);
                }

            } else if (minHeap.size() > maxHeap.size()) {

                if (ele > minHeap.getTop()) {
                    maxHeap.insert(minHeap.removeTop());
                    minHeap.insert(ele);
                } else {
                    maxHeap.insert(ele);
                }

            } else if (minHeap.size() < maxHeap.size()) {

                if (ele > minHeap.getTop()) {
                    minHeap.insert(ele);
                } else {
                    minHeap.insert(maxHeap.removeTop());
                    maxHeap.insert(ele);
                }

            }
        }
    }

}


class Heap {
    public Integer size() {
        return data.size();
    }

    public static enum Type {MIN, MAX};

    private final Boolean isMax;
    private List<Integer> data;

    public Heap (Type type) {
        isMax = type == Type.MAX;
        data = new ArrayList<>();
    }

    public void insert (Integer value) {
        data.add(value);
        heapify(data.size()-1);
    }

    public Integer getTop() {
        return data.size()>0 ? data.get(0) : null;
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
                swap(parentIndex, rightChildIndex);
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

    private boolean isValidIndex(Integer childIndex) {
        return (childIndex >= 0) && (childIndex < data.size());
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

    private void swap(Integer from, Integer to) {

        Integer tmp = data.get(from);
        data.set(from, data.get(to));
        data.set(to, tmp);

    }

    private Integer getParentIndex(Integer childIndex) {
        return ((childIndex-1)/2);
    }
}
