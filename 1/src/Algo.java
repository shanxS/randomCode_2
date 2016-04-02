/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] A = {1,2,3,4, 5};//{1, 2, 3, 6};
    private Integer turns = 2;


    public void run() {
        reverse(0,turns-1);
        reverse(turns, A.length-1);
        reverse(0, A.length-1);

        for (Integer ele : A) {
            System.out.print(ele + " ");
        }
    }

    private void reverse(Integer start, Integer end) {
        while (start < end) {
            Integer temp = A[start];
            A[start] = A[end];
            A[end] = temp;

            ++start;
            --end;
        }
    }

}