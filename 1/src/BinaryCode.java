public class BinaryCode {

    private Integer[] A = {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3,3,3,3,3,3};

    public void run() {

        for (Integer i=0; i<A.length; ++i) {
            A[getOrig(A[i])] += A.length;
        }

        Integer max = Integer.MIN_VALUE;
        Integer maxCount = 0;
        for (Integer i=0; i<A.length; ++i) {
            if (maxCount < getCount(A[i])) {
                maxCount = getCount(A[i]);
                max = i;
            }
        }

        System.out.print(max);
    }

    private int getOrig(Integer ele) {
        return ele%A.length;
    }

    private int getCount(Integer ele) {
        return ele/A.length;
    }
}