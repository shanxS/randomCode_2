public class BinaryCode {

    private Integer[] A = {90, 80, 70, 60, 50};
    private int[] fwd = new int[A.length];
    private int[] rev = new int[A.length];

    public void run() {

        Integer counter = 1;
        Integer minSoFar = A[0];
        fwd[0] = A[0];
        while (counter < A.length) {
            fwd[counter] = minSoFar;
            minSoFar = Math.min(minSoFar, A[counter]);

            ++counter;
        }

        counter = A.length - 2;
        Integer maxSoFar = A[A.length-1];
        while (counter >= 0) {
            rev[counter] = maxSoFar;
            maxSoFar = Math.max(maxSoFar, A[counter]);

            --counter;
        }

        Integer maxFwdGoingProfit = 0;
        Integer maxProfit = rev[0] - A[0];
        counter = 1;
        while (counter < A.length) {
            maxFwdGoingProfit = Math.max(maxFwdGoingProfit, (A[counter-1] - fwd[counter-1]));
            Integer thisProfit = rev[counter] - A[counter] + maxFwdGoingProfit;
            maxProfit = Math.max(thisProfit, maxProfit);

            ++counter;
        }

        System.out.print(maxProfit);

    }
}