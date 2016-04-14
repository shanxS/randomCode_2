import java.util.ArrayDeque;

public class Algo {

    private Integer[] A = {1, 2, 3, 1, 4, 5, 2, 3, 6};
    private final Integer k=3;
    private ArrayDeque<Integer> arrayDeque;

    public void run() {
        arrayDeque = new ArrayDeque<>();

        init();
        processOthers();
    }

    private void processOthers() {
        Integer counter = k;

        while (counter < A.length) {
            System.out.println(A[arrayDeque.peekLast()]);

            while (arrayDeque.size() > k) {
                arrayDeque.removeLast();
            }

            while (arrayDeque.size() > 0 && A[counter] >= A[arrayDeque.peekLast()]) {
                arrayDeque.removeLast();
            }

            arrayDeque.addFirst(counter);

            ++counter;
        }
    }

    private void init() {
        Integer counter = 0;

        while (counter < k) {

            while (arrayDeque.size() > 0 && A[counter] >= A[arrayDeque.peekLast()]) {
                arrayDeque.removeLast();
            }

            arrayDeque.addFirst(counter);

            ++counter;
        }
    }
}
