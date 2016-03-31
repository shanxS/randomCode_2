/**
 * @author shashaku on 29/03/16.
 */
public class Algo {
    private Integer[] A =  {2,2,2,3};//{1, 3, 3, 1, 2};//{2, 2, 3, 5, 2, 2, 6};


    public void run() {
        Integer count = 1;
        Integer index = 0;

        for (Integer i=0; i<A.length; ++i) {
            if (A[index] == A[i]) {
                ++count;
            }
            else {
                --count;
            }

            if (count == 0) {
                count = 1;
                index = i;
            }
        }

        count = 0;
        for (Integer i=0; i<A.length; ++i){
            if (A[i] == A[index]) {
                ++count;
            }
        }

        if (count > A.length/2) {
            System.out.print(A[index]);
        }
        else {
            System.out.print("not found");
        }
    }
}
