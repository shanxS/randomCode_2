public class BinaryCode {

    private Integer[] A = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};

    public void run() {
        Integer w = null, r = 0;

        while (r < A.length) {

            if (A[r] == 0 && w == null) {
                w = r;
            } else if (A[r] != 0 && w != null) {
                A[w] = A[r];
                A[r] = 0;
                ++w;
            }

            ++r;

        }

        for (Integer ele : A) {
            System.out.print(ele + " ");
        }

    }
}