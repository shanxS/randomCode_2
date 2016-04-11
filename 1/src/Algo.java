public class Algo {

    private Integer[] A = {1, 1, 2, 2, 2, 2, 3};

    public void run() {
        Integer target = 4;
        Integer firstOcc = findFirstOccurance(target);
        Integer lastOcc = findLastOccurance(target);


        System.out.print(firstOcc + " " + lastOcc + " " + (lastOcc-firstOcc+1));

    }

    private Integer findLastOccurance (Integer target) {
        Integer mid = null;
        Integer start = 0, end = A.length-1;

        while (start <= end) {
            mid = Math.min(start, end) + ((Math.abs(start-end))/2);

            if (A[mid] == target) {
                if (mid == A.length-1 || A[mid+1] != target) {
                    break;
                } else {
                    start = mid + 1;
                }
            } else if (A[mid] < target) {
                start = mid + 1;
            } else if (A[mid] > target) {
                end = mid-1;
            }
        }


        return mid;
    }


    private Integer findFirstOccurance (Integer target) {
        Integer mid = null;
        Integer start = 0, end = A.length-1;

        while (start <= end) {
            mid = Math.min(start, end) + ((Math.abs(start-end))/2);

            if (A[mid] == target) {
                if (mid == 0 || A[mid-1] != target) {
                    break;
                } else {
                    end = mid - 1;
                }
            } else if (A[mid] < target) {
                start = mid + 1;
            } else if (A[mid] > target) {
                end = mid - 1;
            }
        }

        return mid;

    }

}