public class BinaryCode {

    private Integer[] A =  {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};//{3, 4, 5};//, -3, 100, 1, 89, 54, 23, 20};
    private int targetSize = (A.length % 2 == 0) ? A.length/2 : (A.length-1)/2;
    private int globalMin = Integer.MAX_VALUE;
    private Integer globalWith, globalWithout;

    public void run() {



        int with = A[0], without = 0;
        int withSize = 1, withoutSize = 0;
        findMin(1, with, withSize, without, withoutSize);
        System.out.print(globalMin + " " + globalWith + " " + globalWithout);

    }

    private void findMin(int thisIndex, int prevWith, int prevWithSize, int prevWithout, int prevWithoutSize) {

        if (A.length % 2 == 0) {
            if (prevWithSize == targetSize && prevWithoutSize == targetSize) {
                if (globalMin > Math.abs(prevWith - prevWithout)) {
                    globalMin = Math.abs(prevWith - prevWithout);
                    globalWith = prevWith;
                    globalWithout = prevWithout;
                }

                return;
            }
        } else if (A.length % 2 != 0) {

            if ( prevWithSize > prevWithout
                    && prevWithSize == targetSize+1
                    && prevWithoutSize == targetSize) {
                if (globalMin > Math.abs(prevWith - prevWithout)) {
                    globalMin = Math.abs(prevWith - prevWithout);
                    globalWith = prevWith;
                    globalWithout = prevWithout;
                }

                return;
            } else if ( prevWithSize < prevWithout
                    && prevWithSize == targetSize
                    && prevWithoutSize == targetSize+1) {
                if (globalMin > Math.abs(prevWith - prevWithout)) {
                    globalMin = Math.abs(prevWith - prevWithout);
                    globalWith = prevWith;
                    globalWithout = prevWithout;
                }

                return;
            }

        }

        if (thisIndex >= A.length) {
            return;
        }

        // with
        findMin(thisIndex+1,
                prevWith+A[thisIndex], prevWithSize+1,
                prevWithout, prevWithoutSize);

        findMin(thisIndex+1,
                prevWithout+A[thisIndex], prevWithoutSize+1,
                prevWith, prevWithSize);



    }

}