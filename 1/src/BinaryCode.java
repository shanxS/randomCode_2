public class BinaryCode {

    private Integer[] A = {1,   5,   8,   9,  10,  17,  17,  20};

    public void run() {


        System.out.print(Math.max(findMaxValue (1, 1),
                findMaxValue (1, 0)));

    }

    private int findMaxValue(int thisIndex, int valueSoFar) {
        if (A.length - thisIndex <= 0) {
            return valueSoFar;
        }

        return Math.max(findMaxValue(thisIndex+1, valueSoFar+A[thisIndex]),
                findMaxValue(thisIndex+1, valueSoFar));
    }

}