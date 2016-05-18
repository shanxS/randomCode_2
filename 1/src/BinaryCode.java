public class BinaryCode {

    private Integer[] A = {40, 20, 30, 10, 30};
    private Integer[][] book = new Integer[A.length][A.length];

    int counter = 0;

    public void run() {
        System.out.print(findMin(1, A.length-1) + " " + counter);

    }

    private int findMin(int start, int end) {
        if (start == end) {
            return 0;
        }

        if (book[start][end] != null) {
            return book[start][end];
        }

        ++counter;

        int min = Integer.MAX_VALUE;
        for (int i=start; i<end; ++i) {
            min = Math.min(min,
                    findMin(start,i)
                            + findMin(i+1, end)
                            + (A[start-1] * A[i] * A[end]));
        }

        book[start][end] = min;
        return book[start][end];
    }
}