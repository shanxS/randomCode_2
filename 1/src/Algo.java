public class Algo {

    private int[] A = {80, 60, 30, 40, 20, 10};
    private int[] fwd = new int[A.length];
    private int[] rev = new int[A.length];

    public void run() {
        for (int i=0; i<A.length; ++i) {
            findForFwd(i);
            findForRev(A.length - 1 - i);
        }

        int max = 1;
        for (int i=0; i<A.length; ++i) {
            max = Math.max(max, rev[i]+fwd[i]-1);
        }

        System.out.print(max);
    }

    private int findForRev(int prevIndex) {
        if (rev[prevIndex] > 0) {
            return rev[prevIndex];
        }

        int len = 1;

        for (int i=prevIndex-1; i>=0; --i) {
            if (A[i] < A[prevIndex]) {
                len = Math.max(len, findForRev(i)+1);
            }
        }

        rev[prevIndex] = len;

        return len;
    }

    private int findForFwd(int prevIndex) {

        if (fwd[prevIndex] > 0) {
            return fwd[prevIndex];
        }

        int len = 1;
        for (int i=prevIndex+1; i<A.length; i++) {
            if (A[i] < A[prevIndex]) {
                len = Math.max(len, findForFwd(i) + 1);
            }
        }

        fwd[prevIndex] = len;

        return len;

    }
}