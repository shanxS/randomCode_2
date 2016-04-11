public class Algo {

    private Integer[] A = {0, 1, 2, 3, 4, 5, 6, 7, 10};

    public void run() {

        Integer start = 0, end = A.length-1;

        Integer mid = null;
        while (start <= end) {
            mid = Math.min(start, end) + ((Math.abs(start - end))/2);

            if (A[mid] > mid) {
                end = mid-1;
            } else if (A[mid] == mid) {
                start = mid + 1;
            }
        }

        if (A[mid] == mid) {
            System.out.print("no missing");
        } else {
            System.out.print("missing found at " + mid);
        }

    }

}