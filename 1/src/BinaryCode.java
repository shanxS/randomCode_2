public class BinaryCode {

    private int[] A = {1,1,4,2,5,3,9,5};
    private Integer pass;

    public void run() {
        int[] count = new int[10];
        for (Integer i=0; i<A.length; ++i) {
            count[A[i]] += 1;
        }

        for (Integer i=1; i<count.length; ++i) {
            count[i] += count[i-1];
        }

        for (Integer i : count) {
            System.out.print(i + " ");
        }
        System.out.println();

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