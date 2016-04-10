public class Algo {

    private Integer[] A = {1, 2, 3, 1, 3, 6, 6};
    private final Integer BIG = A.length;

    public void run() {
        for (Integer i=0; i<A.length; ++i) {
            // get orginal number
            Integer number = A[i] % BIG;

            // goto that index and increment BIG
            A[number] += BIG;
        }

        for (Integer i=0; i<A.length; ++i) {
            // get orginal number
            Integer number = A[i] % BIG;

            System.out.println(number + " was repeated " + ((A[number]) / BIG));
        }
    }

}