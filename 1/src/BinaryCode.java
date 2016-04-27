public class BinaryCode {

    private Integer[] A = {1, 3, 4, 7, 10};
    private Integer target = 15;

    public void run() {

        Integer v1 = null, v2 = null;
        Integer diff = Integer.MAX_VALUE;


        Integer start = 0, end = A.length-1;
        while (start < end) {
            Integer sum = A[start] + A[end];

            if (diff > (Math.abs(sum - target))) {
                diff = Math.abs(sum - target);
                v1 = A[start];
                v2 = A[end];
            }

            if (sum == target) {
                break;
            } else if (sum > target) {
                --end;
            } else if (sum < target) {
                ++start;
            }
        }

        System.out.print(v1 + " " + v2);

    }
}