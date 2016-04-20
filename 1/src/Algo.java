import java.util.ArrayList;
import java.util.List;

public class Algo {

    private Integer[] A = {1, 1, 0, -1, -2};

    public void run() {

        Heap heap = new Heap(Heap.Type.MIN);
        for (Integer ele : A) {
            heap.insert(ele);
        }


        Integer min = 1;
        while (heap.size() > 0) {

            Integer top = heap.removeTop();

            if (top > 0) {
                if (top != min) {
                    System.out.print("missing " + min);
                    break;
                } else {
                    ++min;
                }
            }

        }
    }
}

class Heap {
    public enum Type {MIN, MAX};


    private Boolean isMax;
    private List<Integer> data;

    public Heap(Type type) {
        isMax = type == Type.MAX;
        data = new ArrayList<>();
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
        Integer leftChidIndex = getLeftChildIndex(parentIndex);
        Integer rightChildIndex = getRightChildIndex(parentIndex);

        if (isValidIndex(leftChidIndex) && isValidIndex(rightChildIndex)) {

            if ((data.get(leftChidIndex) > data.get(rightChildIndex)) == isMax) {
                if ((data.get(parentIndex) > data.get(leftChidIndex)) != isMax) {
                    swap(leftChidIndex, parentIndex);
                    reverseHeapify(leftChidIndex);
                }
            } else if ((data.get(parentIndex) > data.get(rightChildIndex)) != isMax) {
                swap(rightChildIndex, parentIndex);
                reverseHeapify(rightChildIndex);
            }
        } else if (isValidIndex(leftChidIndex)) {

            if ((data.get(parentIndex) > data.get(leftChidIndex)) != isMax) {
                swap(leftChidIndex, parentIndex);
                reverseHeapify(leftChidIndex);
            }

        } else if (isValidIndex(rightChildIndex)) {

            if ((data.get(parentIndex) > data.get(rightChildIndex)) != isMax) {
                swap(rightChildIndex, parentIndex);
                reverseHeapify(rightChildIndex);
            }

        }
    }

    private boolean isValidIndex(Integer index) {
        return (index>=0) && (index<data.size());
    }

    private Integer getRightChildIndex(Integer parentIndex) {
        return getLeftChildIndex(parentIndex) + 1;
    }

    private Integer getLeftChildIndex(Integer parentIndex) {
        return (2*parentIndex)+1;
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

    private void swap(Integer from, Integer to) {
        Integer tmp = data.get(from);
        data.set(from, data.get(to));
        data.set(to, tmp);
    }

    private Integer getParentIndex(Integer childIndex) {
        return (childIndex-1)/2;
    }
}