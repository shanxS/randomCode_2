public class BinaryCode {


    private int[][] A = {{1, 2, 3},
            {4, 8, 2},
            {1, 5, 3}};

    private final int MAX = 25;
    private Integer[][] book = new Integer[A.length][A[0].length];
    private int counter = 0;

    public void run() {

        System.out.println(findMinPath(0,0));
        System.out.println(counter);

    }

    private Integer findMinPath(int r, int c) {

        if (r>=A.length || c>=A[0].length) {
            return MAX;
        }

        if (book[r][c] != null) {
            return book[r][c];
        }

        ++counter;

        if (r == A.length-1 && c == A[0].length-1) {
             book[r][c] = A[r][c];
        } else {
            book[r][c] = A[r][c] + Math.min(findMinPath(r, c + 1),
                    Math.min(findMinPath(r + 1, c + 1),
                            findMinPath(r + 1, c)));
        }

        return book[r][c];
    }

}