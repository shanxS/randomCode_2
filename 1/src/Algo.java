/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] A = {1,2,3,4, 5};//{1, 2, 3, 6};


    public void run() {
        //System.out.print(gcd (5,7));
        System.out.print(gcd (12,8));
    }

    private Integer gcd(Integer large, Integer small) {
        if (small == 0) {
            return large;
        } else {
            return gcd(small, large % small);
        }
    }

}