public class BinaryCode {

    private Integer[] A = {4,2,3,1,6};

    public void run() {

        int[] count = new int[10];
        for (int i=0; i<A.length; ++i) {
            ++count[A[i]];
        }

        for (int i=1; i<count.length; ++i) {
            count[i] += count[i-1];
        }

        int[] sort = new int[A.length];
        for (int i=0; i<A.length; ++i) {

            sort[count[A[i]] - 1] = A[i];
            --count[A[i]];

        }

        for (int i=0; i<sort.length; ++i) {
            System.out.print(sort[i] + " ");
        }

    }


}