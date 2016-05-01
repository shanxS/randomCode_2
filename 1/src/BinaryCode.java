public class BinaryCode {

    private Integer[] A = {1,9,2,8,4,5,6};

    public void run() {

        sort(0, A.length-1);
        for (Integer ele : A) {
            System.out.print(ele + " ");
        }

    }

    private void sort(Integer start, Integer end) {
        if (start >= end) {
            return;
        }

        Integer mid = start + ((end-start))/2;
        sort(start, mid);
        sort(mid+1, end);

        merge(start, mid, mid+1, end);
    }

    private void merge(Integer start1, Integer end1, Integer start2, Integer end2) {

        Integer counter1 = start1;
        Integer counter2 = start2;
        Integer counter = 0;
        Integer[] tmp = new Integer[(end1-start1+1) + (end2-start2+1)];

        while (counter1 <= end1 && counter2 <= end2) {
            if (A[counter1] > A[counter2]) {
                tmp[counter] = A[counter2];
                ++counter2;
            } else if (A[counter1] < A[counter2]) {
                tmp[counter] = A[counter1];
                ++counter1;
            } else {
                tmp[counter] = A[counter1];
                ++counter1;
                ++counter2;
            }

            ++counter;
        }

        while (counter1 <= end1) {
            tmp[counter] = A[counter1];
            ++counter1;
            ++counter;
        }

        while (counter2 <= end2) {
            tmp[counter] = A[counter2];
            ++counter2;
            ++counter;
        }

        counter = 0;
        for (Integer i=start1; i<=end2; ++i, ++counter) {
            A[i] = tmp[counter];
        }

    }
}