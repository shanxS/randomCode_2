public class BinaryCode {


    private Integer[] A = {0, 1, 1, 1, 1};

    public void run() {

        Integer prevSum = 0;
        Integer maxSum = Integer.MIN_VALUE;
        Integer index = null;

        Integer counter = 0;
        while (counter < A.length) {

            if (A[counter] == 1) {

                Integer start = counter;
                Integer thisSum = 0;
                while (counter < A.length && A[counter] == 1) {
                    thisSum += A[counter];
                    ++counter;
                }

                if (prevSum != 0 && (maxSum < prevSum+thisSum)) {
                    maxSum = prevSum + thisSum;
                    index = start-1;
                } else if (prevSum == 0) {
                    maxSum = thisSum;
                    index = start-1;
                }

                prevSum = thisSum;

            } else if (A[counter] == 0) {

                if (counter+1 < A.length && A[counter+1] == 0) {
                    prevSum = 0;
                }

                while (counter < A.length && A[counter] == 0) {
                    ++counter;
                }

            }

        }

        System.out.print(index + " " + (maxSum+1));

    }

}
