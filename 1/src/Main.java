public class Main {
    public static void main(String[] args) {
        Algo algo = new Algo();
        algo.run();
    }
}

class Algo {
    private int[] A = {
            1000,
            700, 1010,
            500,800,1020,
            400,600,900,
            550,850,950,
            530,570,970
    };

    public void run() {
        sort(0, A.length-1);
        for (Integer i : A) {
            System.out.print(i + " ");
        }
    }

    private void sort(int start, int end) {
        if (start >= end) {
            return;
        }

        int pivotIndex = qsort(start, end);
        sort(start, pivotIndex-1);
        sort(pivotIndex+1, end);
    }

    private int qsort(int start, int end) {
        int marker = start-1;
        int pivot = A[end];

        for (int i=start; i<end; ++i) {
            if (A[i] < pivot) {
                ++marker;
                swap(marker, i);
            }
        }

        swap(marker+1, end);
        return marker+1;
    }

    private void swap (int from, int to) {
        int tmp = A[to];
        A[to] = A[from];
        A[from] = tmp;
    }
}