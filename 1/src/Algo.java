public class Algo {

    private int[] A = {10, 22, 9, 33, 21, 50, 41, 60, 80};

    public void run() {
        System.out.print(findFor(0));
    }

    private int findFor(int prevIndex) {

        int len = 1;
        for (int i=prevIndex+1; i<A.length; ++i) {
            if (A[i] > A[prevIndex]) {
                len = Math.max(len, findFor(i)+1);
            }
        }

        return len;

    }
}