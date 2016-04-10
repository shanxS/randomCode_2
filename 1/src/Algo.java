/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

//    private Integer[] A = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 2};
//    private Integer[] A = {2,2,2,2,0};
    private Integer[] A = {1,1,1,1};

    public void run() {
        Integer endMarker = A.length;
        Integer startMarker = -1;
        Integer marker = 0;

        while (marker<endMarker) {
            if (A[marker] == 0) {
                ++startMarker;
                swap (startMarker, marker);

                ++marker;
            } else if (A[marker] == 2) {
                --endMarker;
                swap (endMarker, marker);
            } else if (A[marker] == 1) {
                ++marker;
            }
        }

        for (Integer ele : A) {
            System.out.print(ele + " ");
        }
    }

    private void swap(Integer from, Integer to) {
        Integer temp = A[from];
        A[from] = A[to];
        A[to] = temp;
    }


}
