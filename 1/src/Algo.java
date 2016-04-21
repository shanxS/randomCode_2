public class Algo {

    private Integer[] A = {80, 60, 30, 40, 20, 10};
    private Integer[] LIS = new Integer[A.length];
    private Integer[] LDS = new Integer[A.length];

    public void run() {
        populateLIS();
        populateLDS();
        System.out.println(findLongestBitonic());

        for (Integer ele : LIS) {
            System.out.print(ele + " ");
        }

        System.out.println();
        for (Integer ele : LDS) {
            System.out.print(ele + " ");
        }
   }

    private Integer findLongestBitonic() {
        Integer num = Integer.MIN_VALUE;

        for (Integer i=0; i<A.length; ++i) {
            num = Math.max((LDS[i] + LIS[i] - 1), num);
        }

        return num;
    }

    private void populateLDS() {
        for (Integer i=A.length-1; i>=0; --i) {
            LDS[i] = 1;
            for (Integer j=A.length-1; j>i; --j) {
                if (A[i] > A[j] && (LDS[i] < (LDS[j]+1))) {
                    LDS[i] = 1+LDS[j];
                }
            }
        }
    }

    private void populateLIS() {

        for (Integer i=0; i<A.length; ++i) {
            LIS[i] = 1;
            for (Integer j=0; j<i; ++j) {
                if (A[j] < A[i] &&  (LIS[i] <  (1+LIS[j]))) {
                    LIS[i] = 1+LIS[j];
                }
            }
        }
    }
}