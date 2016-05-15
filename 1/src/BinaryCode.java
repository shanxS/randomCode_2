public class BinaryCode {


    private int[][] A = {{1, 2, 3},
            {4, 8, 2},
            {1, 5, 3}};

    private final int MAX = 25;
    private int minWeight = Integer.MAX_VALUE;

    public void run() {

        findMinPath(0,1, A[0][0]); findMinPath(1,1, A[0][0]); findMinPath(1,0,A[0][0]);
        System.out.print(minWeight);

    }

    private void findMinPath(int r, int c, int weightSofar) {

        if (r == A.length-1 && c == A[0].length-1) {
            minWeight = Math.min(minWeight, A[r][c] + weightSofar);
        }

        if (r>=A.length || c>=A[0].length) {
            return;
        }

        findMinPath(r,c+1, A[r][c] + weightSofar);
        findMinPath(r+1,c+1, A[r][c] + weightSofar);
        findMinPath(r+1,c, A[r][c] + weightSofar);
    }

}