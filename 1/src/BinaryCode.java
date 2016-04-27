public class BinaryCode {

    private Integer[] A = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
    private Integer target = 180;

    public void run() {

        Integer prevIndex = 0;
        Integer thisIndex = 0;
        Integer power = 1;
        while (thisIndex < A.length && A[thisIndex] < target) {
            prevIndex = thisIndex;
            thisIndex += (int) Math.pow(2, power);
            ++power;
        }

        if (thisIndex > A.length) {
            thisIndex = A.length-1;
        }

        System.out.print(bs(prevIndex, thisIndex, target));

    }

    private String bs(Integer start, Integer end, Integer target) {
        while (start <= end) {
            Integer mid = Math.min(start, end) + ((Math.abs(start-end)))/2;

            if (A[mid].equals( target)) {
                return "found at " + mid;
            } else if (A[mid] < target) {
                start = mid+1;
            } else if (A[mid] > target) {
                end = mid-1;
            }
        }

        return "not found in search";
    }

}