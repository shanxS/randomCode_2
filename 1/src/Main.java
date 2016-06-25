import java.util.*;

public class Main {
    public static void main(String[] args) {
        Algo algo = new Algo();
        algo.run();
    }
}

class Algo {
    public void run() {
        int[] A = {1,4,2,5,3,9,11};
        MaxHeap heap = new MaxHeap();
        for (Integer i : A) {
            heap.add(i);
            System.out.print(heap.peekMax() + " ");
        }

        System.out.println();
        while (heap.size() > 0) {
            System.out.print(heap.getMax() + " ");
        }
    }
}

class MaxHeap {
    private List<Integer> list;

    public MaxHeap() {
        list = new ArrayList<>();
    }

    public int size() {
        return list.size();
    }

    public Integer peekMax() {
        if (list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }
    }

    public Integer getMax() {
        if (list.size() == 0) {
            return null;
        }

        int returnValue = list.get(0);
        swap(0, list.size()-1);
        list.remove((int)(list.size()-1));
        bubbleDown(0);

        return returnValue;
    }

    private void swap (int from, int to) {
        int tmp = list.get(from);
        list.set(from, list.get(to));
        list.set(to, tmp);
    }

    private int getLeftChildIndex(int parentIndex) {
        return (2*parentIndex) + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return getLeftChildIndex(parentIndex) + 1;
    }


    private void bubbleDown(int parentIndex) {
        if (!isValidIndex(parentIndex)) {
            return;
        }

        int rightChildIndex = getRightChildIndex(parentIndex);
        int leftChildIndex = getLeftChildIndex(parentIndex);

        int parentV = list.get(parentIndex);
        if (isValidIndex(rightChildIndex) && isValidIndex(leftChildIndex)) {

            int leftV = list.get(leftChildIndex);
            int rightV = list.get(rightChildIndex);

            if (leftV > rightV) {
                if (leftV > parentV) {
                    swap(leftChildIndex, parentIndex);
                    bubbleDown(leftChildIndex);
                }
            } else if (leftV < rightV) {
                if (rightV > parentV) {
                    swap(rightChildIndex, parentIndex);
                    bubbleDown(rightChildIndex);
                }
            }

        } else if (isValidIndex(rightChildIndex)) {

            int rightV = list.get(rightChildIndex);
            if (rightV > parentV) {
                swap(rightChildIndex, parentIndex);
                bubbleDown(rightChildIndex);
            }

        } else if (isValidIndex(leftChildIndex)) {

            int leftV = list.get(leftChildIndex);
            if (leftV > parentV) {
                swap(leftChildIndex, parentIndex);
                bubbleDown(leftChildIndex);
            }

        }


    }

    public void add (int val) {
        list.add(val);
        bubbleUp(list.size()-1);
    }

    private void bubbleUp(int childIndex) {
        int parentIndex = getParentIndex(childIndex);

        if (parentIndex == childIndex) {
            return;
        }

        if (isValidIndex(parentIndex) && list.get(childIndex) > list.get(parentIndex)) {
            swap (childIndex, parentIndex);
            bubbleUp(parentIndex);
        }
    }

    private boolean isValidIndex(int index) {
        return (index >= 0 )  && (index < list.size());
    }

    private int getParentIndex(int childIndex) {
        return (childIndex-1) / 2;
    }
}























