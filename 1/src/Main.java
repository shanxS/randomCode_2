import lombok.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] A = {3,1,8,4,5};
        Heap h = new Heap(Heap.Type.MIN);
        for (Integer i : A) {
            h.add(i);
            System.out.println(h.peep());
        }


        System.out.println();
        while (h.size() > 0) {
            System.out.print(" " + h.removeTop());
        }
    }
}

class Heap {
    public static enum Type {MAX, MIN};

    @Getter @Setter
    private final boolean isMax;

    private List<Integer> list;

    public Heap(Type type) {
        this.isMax = (type.MAX == type);
        list = new ArrayList<>();
    }


    public Integer removeTop() {
        if (list.size() == 0) {
            return null;
        }

        int returnValue = list.get(0);
        swap(0, list.size()-1);
        list.remove((int)(list.size()-1));
        bubbleDown(0);

        return returnValue;
    }

    private void bubbleDown(int parentIndex) {
        if (!isValidIndex(parentIndex)) {
            return;
        }

        int leftChildIndex = getLeftChildIndex(parentIndex);
        int rightChildIndex = getRightChildIndex(parentIndex);

        int parentV = list.get(parentIndex);
        if (isValidIndex(leftChildIndex) && isValidIndex(rightChildIndex)) {
            int leftV = list.get(leftChildIndex);
            int rightV = list.get(rightChildIndex);

            if ((leftV > rightV) == isMax) {
                if ((parentV > leftV) != isMax) {
                    swap(parentIndex, leftChildIndex);
                    bubbleDown(leftChildIndex);
                }
            } else {
                if ((parentV > rightV) != isMax) {
                    swap(parentIndex, rightChildIndex);
                    bubbleDown(rightChildIndex);
                }
            }
        } else if (isValidIndex(leftChildIndex)) {
            if ((parentV > list.get(leftChildIndex)) != isMax) {
                swap(parentIndex, leftChildIndex);
                bubbleDown(leftChildIndex);
            }
        } else if (isValidIndex(rightChildIndex)) {
            if ((parentV > list.get(rightChildIndex)) != isMax) {
                swap(parentIndex, rightChildIndex);
                bubbleDown(rightChildIndex);
            }
        }
    }

    private int getLeftChildIndex(int index){
        return (index*2) + 1;
    }

    private int getRightChildIndex(int index) {
        return 1 + getLeftChildIndex(index);
    }

    public void add(int val) {
        list.add(val);
        bubbleUp(list.size()-1);
    }

    public int size() {
        return list.size();
    }

    public Integer peep() {
        if (list.size() == 0) {
            return null;
        }

        return list.get(0);
    }

    private void bubbleUp(int childIndex) {
        int parentIndex = getParentIndex(childIndex);

        if (parentIndex == childIndex) {
            return;
        }

        if (isValidIndex(parentIndex) &&
                (list.get(parentIndex) > list.get(childIndex)) != isMax) {
            swap(parentIndex, childIndex);
            bubbleUp(childIndex);
        }

    }

    private void swap(int from, int to) {
        int tmp = list.get(from);
        list.set(from, list.get(to));
        list.set(to, tmp);
    }

    private boolean isValidIndex(int index) {
        return (index >= 0) && (index < list.size());
    }

    private int getParentIndex (int childIndex) {
        return (childIndex-1)/2;
    }

}












