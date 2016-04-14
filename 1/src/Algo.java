public class Algo {

    private Integer[] A = {4, 3, 6, 2, 1, 1};

    public void run() {

        for(Integer i=0; i<A.length; ++i) {
            if (A[Math.abs(A[i]) - 1] < 0) {
                System.out.print("repeated " + Math.abs(A[i]));
            } else {
                A[Math.abs(A[i]) - 1] = -A[Math.abs(A[i]) - 1];
            }
        }

        for(Integer i=0; i<A.length; ++i) {
            if (A[i] > 0) {
                System.out.print("not found " + (i+1));
            }
        }
    }
}