public class BinaryCode {

    private Integer[] S = {15, 13, 11, 10, 12, 10, 9, 8, 7, 5};
    private Integer N;
    private Integer[] A;

    public void run() {

        findN();
        System.out.println("N " + N);

        findInners();

        findLimits();

        for (Integer ele : A) {
            System.out.print(ele + " ");
        }

    }

    private void findLimits() {
        A[0] = S[0] - A[1];
        A[N-1] = S[S.length-1] - A[A.length-2];
    }

    private void findInners() {

        A = new Integer[N];
        Integer end = 0;
        for (Integer i=1; i<A.length-1; ++i) {
            end += N-i;
            A[i] = (S[end] + S[i-1] - S[i])/2;
        }

    }

    private void findN() {

        Integer sum = S.length;

        Integer D = (int)Math.sqrt((1 + (8*sum)));

        if (S.length % 2 != 0) {
            N = (D - 1) / 2;
        } else {
            N = (D + 1) / 2;
        }

    }

}