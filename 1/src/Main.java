import java.util.*;

public class Main {
    public static void main(String[] args) {
        Algo algo = new Algo();
        algo.run();
    }
}

class Algo {
    private int[] A = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};

    public void run() {

        MeanFinder meanF = new MeanFinder();
        List<Integer> numsSoFar = new ArrayList<>();
        for (Integer i : A) {
            meanF.add(i);
            numsSoFar.add(i);
            Collections.sort(numsSoFar);
            System.out.println(numsSoFar + " mean " + meanF.meanSoFar() + " ");
        }
    }
}

class MeanFinder {
    private MinHeap bigs;
    private MaxHeap smalls;

    public MeanFinder() {
        bigs = new MinHeap();
        smalls = new MaxHeap();
    }

    public Integer meanSoFar() {
        if (bigs.size() == 0 && smalls.size() == 0) {
            return null;
        } else if (bigs.size() > smalls.size()) {
            return bigs.peep();
        } else if (bigs.size() < smalls.size()) {
            return smalls.peep();
        } else {
            return (bigs.peep() + smalls.peep()) / 2;
        }
    }

    public void add (int num) {
        if (bigs.size() == 0 && smalls.size() == 0) {
            bigs.push(num);
        } else if (bigs.size() == 1 && smalls.size() == 0) {
            if (bigs.peep() < num) {
                smalls.push(bigs.pop());
                bigs.push(num);
            } else {
                smalls.push(num);
            }
        } else {
            if (bigs.peep() < num) {
                if (bigs.size() > smalls.size()) {
                    smalls.push(bigs.pop());
                }
                bigs.push(num);
            } else if (bigs.peep() > num) {
                if (smalls.size() > bigs.size()) {
                    bigs.push(smalls.pop());
                }
                smalls.push(num);
            }
        }
    }
}


class MaxHeap {
    private List<Integer> list;

    public MaxHeap () {
        list = new ArrayList<>();
    }

    public Integer peep() {
        if (list.size() == 0) {
            return null;
        }

        return list.get(0);
    }

    public Integer pop() {
        if (list.size() == 0) {
            return null;
        }

        int returnValue = list.get(0);
        swap(0, list.size()-1);
        list.remove((int)(list.size() - 1));
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

            if (leftV > rightV) {
                if (parentV < leftV) {
                    swap(parentIndex, leftChildIndex);
                    bubbleDown(leftChildIndex);
                }
            } else {
                if (parentV < rightV) {
                    swap(parentIndex, rightChildIndex);
                    bubbleDown(rightChildIndex);
                }
            }
        } else if (isValidIndex(leftChildIndex)) {
            if (list.get(leftChildIndex) > parentV) {
                swap(leftChildIndex, parentIndex);
                bubbleDown(leftChildIndex);
            }
        } else if (isValidIndex(rightChildIndex)) {
            if (list.get(rightChildIndex) > parentV) {
                swap(rightChildIndex, parentIndex);
                bubbleDown(rightChildIndex);
            }
        }
    }

    private int getLeftChildIndex(int index) {
        return (2*index) + 1;
    }

    private int getRightChildIndex(int index) {
        return 1 + getLeftChildIndex(index);
    }


    public int size() {
        return list.size();
    }

    public void push(int val) {
        list.add(val);
        bubbleUp(list.size()-1);
    }

    private void bubbleUp(int childIndex) {
        int parentIndex = getParentIndex(childIndex);
        if (parentIndex == childIndex) {
            return;
        }

        if (isValidIndex(parentIndex) && list.get(parentIndex) < list.get(childIndex)) {
            swap(parentIndex, childIndex);
            bubbleUp(parentIndex);
        }
    }

    private boolean isValidIndex(int index) {
        return (index >= 0) && (index < list.size());
    }

    private int getParentIndex(int childIndex) {
        return (childIndex-1)/2;
    }

    private void swap(int from, int to) {
        int tmp = list.get(from);
        list.set(from, list.get(to));
        list.set(to, tmp);
    }
}


class MinHeap {
    private List<Integer> list;

    public MinHeap() {
        list = new ArrayList<>();
    }

    public Integer pop() {
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
            int rightV = list.get(rightChildIndex);
            int leftV = list.get(leftChildIndex);

            if (leftV < rightV) {
                if (parentV > leftV) {
                    swap(leftChildIndex, parentIndex);
                    bubbleDown(leftChildIndex);
                }
            } else {
                if (parentV > rightV) {
                    swap(rightChildIndex, parentIndex);
                    bubbleDown(rightChildIndex);
                }
            }
        } else if (isValidIndex(leftChildIndex)) {

            if (list.get(leftChildIndex) < parentV) {
                swap(leftChildIndex, parentIndex);
                bubbleDown(leftChildIndex);
            }

        } else if (isValidIndex(rightChildIndex)) {

            if (list.get(rightChildIndex) < parentV) {
                swap(rightChildIndex, parentIndex);
                bubbleDown(rightChildIndex);
            }

        }
    }

    private int getLeftChildIndex(int index) {
        return (2*index) + 1;
    }

    private int getRightChildIndex(int index) {
        return 1 + getLeftChildIndex(index);
    }

    public int size() {
        return list.size();
    }

    public void push(int val) {
        list.add(val);
        bubbleUp(list.size()-1);
    }

    public Integer peep() {
        if (list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }
    }

    private void bubbleUp(int childIndex) {
        int parentIndex = getParentIndex(childIndex);

        if (parentIndex == childIndex) {
            return;
        }

        if (isValidIndex(parentIndex) && list.get(parentIndex) > list.get(childIndex)) {
            swap(parentIndex, childIndex);
            bubbleUp(childIndex);
        }

    }

    private int getParentIndex(int childIndex) {
        return (childIndex-1)/2;
    }

    private boolean isValidIndex(int index) {
        return (index >= 0) && (index < list.size());
    }

    private void swap(int from, int to) {
        int tmp = list.get(from);
        list.set(from, list.get(to));
        list.set(to, tmp);
    }
}









