public class BinaryCode {

    private Integer[] A = {1, 2, 3, 4, 5, 6};

    public void run() {
        Integer counter = 1;
        for (Integer i=0; i<A.length; ++i){

            if (A[i] > counter) {
                break;
            } else if (A[i] < counter || A[i] == counter) {
                counter += A[i];
            }
        }

        System.out.print("cant amke " + counter);

    }
}