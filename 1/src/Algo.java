/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] A = {1, 12, 15, 26};//{1, 2, 3, 6};

    public void run() {
        Integer s = 0;
        Integer e = A.length - 1;

        while (s < e) {
            Integer temp = A[s];
            A[s] = A[e];
            A[e] = temp;

            ++s;
            --e;
        }

        for (Integer ele : A) {
            System.out.print(ele + " ");
        }
    }

}