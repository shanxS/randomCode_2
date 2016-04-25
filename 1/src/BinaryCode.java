public class BinaryCode {

    Integer[][] A = {
            {0, 0, 0, 1},
            {0, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 0, 0, 0}
    };

    public void run() {

        Integer minIndex = A[0].length;
        for (Integer[] arr : A) {
            minIndex = Math.min(minIndex, firstOccurance(arr));
        }

        System.out.print(A[0].length - minIndex);

    }

    private Integer firstOccurance (Integer[] A) {

        Integer start = 0, end = A.length-1;

        while (start <= end) {
            Integer mid = Math.min(start, end) + ((Math.abs(start-end))/2);
            if (A[mid] == 0) {
                start = mid+1;
            } else if (A[mid] == 1) {
                if (mid-1 < 0) {
                    return mid;
                } else if (A[mid-1] == 0) {
                    return mid;
                } else {
                    end = mid-1;
                }
            }
        }

        return A.length;

    }
}