public class BinaryCode {

    private Integer[] A = {10,20};

    public void run() {

        System.out.print(getMin(1, A.length-1));

    }

    private int getMin(int start, int end) {

        if (start == end) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i=start; i<end; ++i) {
            min = Math.min(min, (
                    getMin(start, i) +
                    getMin(i+1, end) +
                            (A[start-1] * A[i] * A[end])

                    ));
        }


        return min;
    }

}