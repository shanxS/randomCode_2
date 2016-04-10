public class Algo {

    private Integer[] A = {-7, 1, 5, 2, -4, 3, 0};

    public void run() {
        Integer total = 0;
        for (Integer ele : A) {
            total += ele;
        }

        Integer sumSoFar = 0;
        for (Integer i=0; i<A.length; ++i) {
            Integer ele = A[i];
            if (sumSoFar == (total-sumSoFar-ele)) {
                System.out.println("equilb " + i);
            }

            sumSoFar += ele;
        }
    }

}