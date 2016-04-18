public class Algo {

    private Integer[] A = {-10, -5, 0, 3, 7};

    public void run() {
        System.out.print(find(0, A.length-1));
    }

    private Integer find(Integer start, Integer end) {

        while (start <= end) {
            Integer mid = Math.min(start, end) + ((Math.abs(start-end))/2);

            if (A[mid] == mid) {
                return mid;
            } else if (A[mid] > mid) {
                end = mid-1;
            } else if (A[mid] < mid) {
                start = mid+1;
            }
        }

        return -1;
    }
}