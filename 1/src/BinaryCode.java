public class BinaryCode {

    private Integer[] A = {1, 4, 5, 7};
    private Integer[] B = {10, 20, 30, 40};
    private Integer target = 30;

    public void run() {

        Integer fwd = 0;
        Integer rev = B.length-1;

        Integer minDiff = Integer.MAX_VALUE;
        Integer v1 = null;
        Integer v2 = null;

        while (rev >= 0 && fwd < A.length) {

            Integer sum = A[fwd] + B[rev];

            if (minDiff > Math.abs(sum-target)) {

                minDiff = Math.abs(sum-target);
                v1 = A[fwd];
                v2 = B[rev];

            }

            if (sum > target) {
                --rev;
            } else if (sum < target){
                ++fwd;
            } else {
                break;
            }
        }

        System.out.print(minDiff + " " + v1 + " " + v2);

    }

}