public class BinaryCode {

    private Integer[] A = {10, 22, 5, 75, 65, 80};

    public void run() {


        Integer[] first = new Integer[A.length];
        Integer buyValue = A[0];
        Integer maxProfit = Integer.MIN_VALUE;
        for (Integer i=1; i<A.length; ++i) {

            Integer profit = A[i] - buyValue;
            maxProfit = Math.max(maxProfit, profit);

            first[i] = maxProfit;
            buyValue = Math.min(buyValue, A[i]);
        }

        Integer totalProfit = Integer.MIN_VALUE;
        Integer sellValue = A[A.length-1];
        for (Integer i=A.length-1; i>0; --i) {

            if (i==A.length-1) {
                totalProfit = first[i];
            } else {
                Integer thisProfit = sellValue - A[i];
                Integer thisTotalProfit = ((first[i-1] == null) ? (0) : (first[i-1])) + thisProfit;

                totalProfit = Math.max(thisTotalProfit, totalProfit);
            }


            sellValue = Math.max(sellValue, A[i]);
        }


        System.out.print(totalProfit);


    }

}