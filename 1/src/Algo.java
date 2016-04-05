/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] A = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};

    public void run() {


        Integer marker = -1;
        for (Integer i=0; i<A.length; ++i) {
            if (A[i] == 0) {
                ++marker;
                swap(marker, i);
            }
        }

        for (Integer ele : A){
            System.out.print(ele + " ");
        }

    }

    private void swap(Integer from, Integer to) {
        Integer temp = A[from];
        A[from] = A[to];
        A[to] = temp;
    }
}