public class BinaryCode {

    private Integer[] A = {3,   5,   8,   9,  10,  17,  17,  20};//{1,   5,   8,   9,  10,  17,  17,  20};

    public void run() {

        int thisIndex = 0;

        System.out.print(Math.max(
                    A[thisIndex] + findMax(thisIndex+1, A.length-(thisIndex+1)),
                    Math.max(
                            findMax(thisIndex+1, A.length),
                            A[thisIndex] + findMax(thisIndex, A.length-(thisIndex+1))
                    )

                )
        );

    }

    private int findMax(int thisIndex, int sizeAvailable) {
        if (thisIndex >= A.length) {
            return 0;
        } else if (thisIndex+1 > sizeAvailable) {
            return 0;
        }

        return Math.max(
                A[thisIndex] + findMax(thisIndex+1, sizeAvailable-(thisIndex+1)),
                Math.max(
                        findMax(thisIndex+1, sizeAvailable),
                        A[thisIndex] + findMax(thisIndex, sizeAvailable-(thisIndex+1))
                )

        );

    }

}