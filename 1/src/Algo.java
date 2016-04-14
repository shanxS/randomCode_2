import java.util.ArrayDeque;

public class Algo {

    private Integer[] A = {1, 2, 3, 1, 4, 5, 2, 3, 6};
    private ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
    private final Integer size = 3;

    public void run() {
        init();
        processForOthers();
    }

    private void processForOthers() {
        Integer counter = size;

        while (counter < A.length) {

            System.out.println(A[arrayDeque.getLast()]);

            while (arrayDeque.size() > size) {
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

        while (counter < size) {
            while (arrayDeque.size() > 0 && A[counter] >= A[arrayDeque.peekLast()]) {
                arrayDeque.removeLast();
            }

            arrayDeque.addFirst(counter);
            ++counter;
        }
    }
}