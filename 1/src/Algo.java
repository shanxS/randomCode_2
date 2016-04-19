public class Algo {

    private Integer[] A = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};

    public void run() {

        System.out.print(A[getFlexi()]);

    }

    private Integer getFlexi() {
        Integer start = 0;
        Integer end = A.length-1;

        while (start <= end) {
            Integer mid = Math.min(start, end) + ((Math.abs(start-end))/2);

            if ((mid+1) < A.length
                    && (mid-1) >= 0) {

                if (A[mid] > A[mid-1]
                        && A[mid] > A[mid+1]) {
                    return mid;
                } else if (A[mid] > A[mid-1]) {
                    start = mid+1;
                } else if (A[mid] < A[mid-1]) {
                    end = mid-1;
                }

            } else if ((mid+1) == A.length) {

                if (A[mid] > A[mid-1]) {
                    return mid;
                }
//                else {
//                    end = mid-1;
//                }

            } else if ((mid-1) < 0) {

                if (A[mid] > A[mid+1]) {
                    return mid;
                }
//                else {
//                    start = mid+1;
//                }

            }
        }

        return null;
    }

}