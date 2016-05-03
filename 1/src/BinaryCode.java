public class BinaryCode {

    private int[] A = {2,23,12,12,11,4,50};
    private Integer pass;

    public void run() {

        Integer max = Integer.MIN_VALUE;
        for (Integer ele : A) {
            max = Math.max(max, ele);
        }

        int[] count = new int[max + 1];
        for (Integer i=0; i<A.length; ++i) {
            ++count[A[i]];
        }

        for (Integer i=1; i<count.length; ++i) {
            count[i] += count[i-1];
        }

        int[] sorted = new int[A.length];
        for (Integer i=0; i<A.length; ++i) {
            sorted[count[A[i]] - 1] = A[i];
            --count[A[i]];
        }

        for (Integer ele : sorted) {
            System.out.print(ele + " ");
        }

    }
}