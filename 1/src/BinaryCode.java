public class BinaryCode {


    private Integer[] A = {3, 6, 5, 10, 7, 20};

    public void run() {

        Integer counter = 1;
        while (counter < A.length) {

            if (A[counter-1] < A[counter]) {
                swap(counter, counter-1);
            } else if (counter+1 < A.length
                    && A[counter] > A[counter+1]) {
                swap(counter, counter+1);
            }

            counter += 2;
        }

        for (Integer ele : A) {
            System.out.print(ele + " ");
        }
    }

    public void swap(Integer from, Integer to) {
        Integer tmp = A[from];
        A[from] = A[to];
        A[to] = tmp;
    }
}