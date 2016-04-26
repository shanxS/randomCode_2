public class BinaryCode {

    private Integer[] A = {90, 80, 70, 60, 50};

    public void run() {

        Integer[] first = new Integer[A.length];
        first[0] = 0;
        Integer minBuyValue = A[0];
        for (Integer i=1; i<A.length; ++i) {
            Integer thisProfit = A[i] - minBuyValue;
            first[i] = Math.max(first[i-1], thisProfit);

            minBuyValue = Math.min(A[i], minBuyValue);
        }

        Integer maxSellValue = A[A.length-1];
        Integer totalProfit = Integer.MIN_VALUE;
        for (Integer i=A.length-1; i>0; --i) {
            Integer thisProfit = maxSellValue - A[i];
            totalProfit = Math.max(totalProfit, thisProfit+first[i-1]);

            maxSellValue = Math.max(maxSellValue, A[i]);
        }

        System.out.print(totalProfit);
    }

}