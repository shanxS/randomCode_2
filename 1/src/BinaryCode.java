public class BinaryCode {

    private int val[] = {60, 100, 120};
    private int wt[] = {10, 20, 30};
    private int  W = 50;

    public void run() {

        System.out.print(Math.max(findMaxValue(1, W-wt[0], val[0]),
                findMaxValue(1, W, 0)));

    }

    private int findMaxValue(int thisIndex, int w, int valueSoFar) {
        if (w == 0) {
            return valueSoFar;
        } else if (w < 0) {
            return -1;
        } else if (thisIndex >= wt.length) {
            return valueSoFar;
        }

        int inclusive = (w-wt[thisIndex] >= 0) ? findMaxValue(thisIndex+1, w-wt[thisIndex], val[thisIndex] + valueSoFar) : valueSoFar;
        return Math.max(inclusive,
                findMaxValue(thisIndex + 1, w, valueSoFar));
    }
}