/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    public void run() {
        Integer[] A = {2,7,5,8,4,6,3};//{3,2,1};
        MergeSort ms = new MergeSort();
        ms.process(A);
        for (Integer ele : A) {
            System.out.print(ele + " ");
        }
    }
}

class MergeSort {
    private Integer[] A;
    public void process(Integer[] A) {
        this.A = A;
        sort(0, A.length-1);
    }

    private void sort (Integer start, Integer end) {
        if (end == start) {
            return;
        }

        Integer start1 = start;
        Integer end1 = mean (start1, end);
        sort(start1, end1);

        Integer start2 = end1 + 1;
        Integer end2 = end;
        sort(start2, end2);

        merge(start1, end1, start2, end2);
    }

    private void merge(Integer start1, Integer end1, Integer start2, Integer end2) {
        Integer marker1 = start1;
        Integer marker2 = start2;

        Integer[] tempA = new Integer[(end1-start1+1) + (end2-start2+1)];
        Integer marker = 0;

        while (marker1 <= end1 && marker2 <= end2) {
            if (A[marker1] < A[marker2]) {
                tempA[marker] = A[marker1];
                ++marker1;
            } else if (A[marker2] < A[marker1]) {
                tempA[marker] = A[marker2];
                ++marker2;
            }

            ++marker;
        }

        while (marker1 <= end1) {
            tempA[marker] = A[marker1];
            ++marker1;
            ++marker;
        }

        while (marker2 <= end2) {
            tempA[marker] = A[marker2];
            ++marker2;
            ++marker;
        }

        marker = 0;
        for (Integer i=start1; i<=end2; ++i, ++marker) {
            A[i] = tempA[marker];
        }
    }


    private Integer mean(Integer num1, Integer num2) {
        return Math.min(num1, num2) + ((Math.abs(num1-num2))/2);
    }
}