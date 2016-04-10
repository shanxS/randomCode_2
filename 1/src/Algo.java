public class Algo {

    private Integer[] A = {1, 2, 3, 1, 3, 6, 6};

    public void run() {
        for (Integer i=0; i<A.length; ++i) {
            if (A[Math.abs(A[i])] < 0) {
                System.out.println("repeated " + Math.abs(Math.abs(A[i])));
            } else {
                A[Math.abs(A[i])] = -1*A[Math.abs(A[i])];
            }
        }
    }
}