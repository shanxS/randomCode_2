/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] A = {1,2,3,4, 5};//{1, 2, 3, 6};


    public void run() {

        //rightTurner(3);
        leftTurner(1);

        for (Integer ele : A) {
            System.out.print(ele + " ");
        }
    }

    private void rightTurner(final Integer turns) {
        Integer from = A.length - 1;
        Integer holder = A[from];
        Integer counter = 0;

        while (counter < A.length) {
            Integer to = (turns + from) % A.length;
            Integer temp = holder;
            holder = A[to];
            A[to] = temp;
            from = to;

            ++counter;
        }
    }

    private void leftTurner(final Integer turns) {
        rightTurner(A.length - turns);
    }
}