public class BinaryCode {

    private Integer[] A = {1, 5, 10, 8, 9};
    Integer[] maxL = new Integer[A.length];
    Integer[] maxR = new Integer[A.length];

    public void run() {

        maxR[A.length-2] = A[A.length-1];
        maxL[1] = A[0];


        Integer fwd = 2;
        Integer rev = A.length-3;
        while (fwd < A.length && rev >= 0) {
            maxL[fwd] = Math.max(maxL[fwd-1], A[fwd-1]);
            ++fwd;

            maxR[rev] = Math.max(maxR[rev+1], A[rev+1]);
            --rev;
        }

        Integer[] values = new Integer[3];
        Integer maxProd = Integer.MIN_VALUE;
        for (Integer i=1; i<A.length-1; ++i) {
            Integer biggestLeft = findBiggestLeft (i);
            Integer biggestRight = findBiggestRight (i);
            if (biggestLeft != null
                    && biggestRight != null
                    && maxProd < biggestLeft * biggestRight * A[i]) {
                maxProd = biggestLeft * biggestRight * A[i];
                values[0] = biggestLeft;
                values[1] = A[i];
                values[2] = biggestRight;
            }
        }

        System.out.println(maxProd);
        for (Integer ele : values) {
            System.out.print(ele + " ");
        }

    }

    private Integer findBiggestRight(Integer thisIndex) {
        if (maxR[thisIndex] <= A[thisIndex]) {
            return null;
        } else {
            return maxR[thisIndex];
        }
    }

    private Integer findBiggestLeft(Integer thisIndex) {
        if (maxL[thisIndex] < A[thisIndex]) {
            return maxL[thisIndex];
        } else {
            return findSmaller(1, thisIndex-1, A[thisIndex]);
        }
    }

    private Integer findSmaller(int start, Integer end, Integer target) {
        while (start <= end) {
            Integer mid = Math.min(start, end) + ((Math.abs(start-end))/2);

            if (maxL[mid] < target){

                if ((mid+1 > end) || (maxL[mid+1] >= target)) {
                    return maxL[mid];
                } else {
                    start = mid + 1;
                }
            } else if ((maxL[mid] == target)
                    || (maxL[mid] > target)) {
                end = mid - 1;
            }

        }

        return null;
    }
}