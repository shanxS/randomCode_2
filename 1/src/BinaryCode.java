public class BinaryCode {

    private Integer[] A = {0, 0, 0, 0, 0, 0, 0};

    public void run() {

        System.out.print((findLast() + 1));

    }

    private Integer findLast() {

        Integer start = 0;
        Integer end = A.length-1;

        while (start <= end) {

            Integer mid = Math.min(start, end) + ((Math.abs(start-end))/2);
            if (A[mid] == 1) {

                if (mid+1 == A.length
                        || A[mid+1] == 0) {
                    return mid;
                } else {
                    start = mid+1;
                }

            } else {
                end = mid-1;
            }

        }

        return null;
    }


}