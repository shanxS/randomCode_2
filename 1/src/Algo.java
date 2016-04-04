/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[][] ARR = {{1, 1, 1, 2, 2},
                             {1, 1, 2, 4, 4, 4, 6, 6},
                             {1, 2, 3, 3, 3, 3, 10},
                             {12, 13, 1, 10, 34, 1}};

    public void run() {

        for (Integer[] arr : ARR) {
            find(arr);
        }


    }

    private void find(Integer[] A) {
        Integer num = A[0];
        Integer count = 1;

        for (Integer i=1; i<A.length; ++i) {
            if (A[i] == num) {
                ++count;
            } else {
                --count;
                if (count == 0) {
                    num = A[i];
                    count = 1;
                }
            }
        }

        count = 0;
        for (Integer i=0; i<A.length; ++i) {
            if (A[i] == num) {
                ++count;
            }
        }

        if (count >= A.length/2) {
            System.out.println("foudn " + num);
        } else {
            System.out.println("not found");
        }
    }
}