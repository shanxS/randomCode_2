public class BinaryCode {

    private Integer[] A = {3,1,2,2,2,1,4,3,3};
    private Integer k = 4;

    public void run() {

        sort(0, A.length-1);

        Integer counter = 0;
        while (counter < A.length) {

            Integer thisValue = A[counter];
            Integer valueCount = 1;
            ++counter;
            while (counter < A.length && A[counter] == thisValue) {
                ++valueCount;
                ++counter;
            }

            if (valueCount > (A.length/k)) {
                System.out.println(thisValue);
            }

        }
    }

    private void sort(int start, int end) {
        if (start >= end) {
            return;
        }

        Integer pivot = qSort(start, end);
        sort(start, pivot-1);
        sort(pivot+1, end);
    }

    private Integer qSort(int start, int end) {
        Integer marker = start-1;
        Integer pivotValue = A[end];

        for (Integer i=start; i<end; ++i) {
            if (A[i] <= pivotValue) {
                ++marker;
                swap(marker, i);
            }
        }

        swap(marker+1, end);
        return marker+1;
    }

    private void swap(int from, int to) {
        Integer tmp = A[from];
        A[from] = A[to];
        A[to] = tmp;
    }
}