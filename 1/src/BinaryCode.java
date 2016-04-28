public class BinaryCode {

    private Integer[] A = {3, 2, 1, 0};
    public void run() {

        Integer[] res = new Integer[A.length];
        for (Integer i=0; i<A.length; ++i) {
            if (A[i] >= 0 && A[i] < A.length) {
                Integer j=A[i];
                res[j] = i;
            }
        }

        for (Integer i=0; i<res.length; ++i) {
            if (res[i] != null) {
                System.out.print(res[i] +" ");
            } else {
                System.out.print(A[i] +" ");
            }
        }

    }

}