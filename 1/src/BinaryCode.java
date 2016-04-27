public class BinaryCode {

    private Integer[] A = {2, 3, 4, 5, 6};
    public void run() {

        Integer prev = 1;
        for (Integer i=0; i<A.length; ++i) {
            Integer nextPrev = A[i];

            if (i==0) {
                A[i] *= A[i+1];
            } else if (i == A.length-1) {
                A[i] *= prev;
            } else {
                A[i] = prev * A[i+1];
            }

            prev = nextPrev;
        }

        for (Integer ele : A) {
            System.out.print(ele + " ");
        }

    }

}