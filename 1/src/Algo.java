/**
 * @author shashaku on 29/03/16.
 */
public class Algo {
    private Integer[] A =  {0,0,1,2};//{1, 3, 3, 5, 2};//{2,2,2,1};


    public void run() {
        for (Integer i=0; i<A.length; ++i) {
            Integer orig = A[i] % A.length;
            Integer addend = (orig == 0) ? A.length : (A.length * (orig));
            A[orig] += addend;
        }

        Integer maxValue = 0;
        Integer maxCount = (A[0] - (A[0] % A.length)) / A.length;
        for (Integer i=1; i<A.length; ++i) {
            Integer orig = A[i] % A.length;
            Integer count = (A[i] - orig) / (A.length * (i));

            if (count > maxCount) {
                maxCount = count;
                maxValue = i;
            }
        }

        System.out.print(maxValue + " " + maxCount);
    }
}
