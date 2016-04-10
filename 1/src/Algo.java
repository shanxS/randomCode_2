/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] A = {4, 2, 4, 5, 2, 3, 1};
    private Integer range = 5;

    public void run() {
        int[] res = new int[range+1];

        for (Integer ele : A) {
            res[ele]++;
        }

        for (Integer i=0; i<res.length; ++i) {
            Integer ele = res[i];
            if (ele == 2) {
                System.out.print((i) + " ");
            }
        }


    }


}
