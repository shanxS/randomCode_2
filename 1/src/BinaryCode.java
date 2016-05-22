public class BinaryCode {

    private Integer[] A = {1,   5,   8,   9,  10,  17,  17,  20};//{1,   5,   8,   9,  10,  17,  17,  20};

    public void run() {

        int thisIndex = 0;

        System.out.print(Math.max(
                findMax(thisIndex+1, A[thisIndex], A.length-(thisIndex+1)),

                Math.max(
                        findMax(thisIndex+1, 0, A.length),
                        findMax(thisIndex, A[thisIndex], A.length-(thisIndex+1))
                )
        ));

    }

    private int findMax(int thisIndex, Integer valueSoFar, int sizeAvailable) {
        if (thisIndex >= A.length) {
            return valueSoFar;
        } else if (sizeAvailable == 0) {
            return valueSoFar;
        }

        if ((thisIndex+1) <= sizeAvailable) {

            return Math.max(
                    findMax(thisIndex+1, valueSoFar+A[thisIndex], sizeAvailable-(thisIndex+1)),

                    Math.max(
                        findMax(thisIndex+1, valueSoFar, sizeAvailable),
                        findMax(thisIndex, valueSoFar+A[thisIndex], sizeAvailable-(thisIndex+1))
                    )
            );

        } else {
            return valueSoFar;
        }
    }

}