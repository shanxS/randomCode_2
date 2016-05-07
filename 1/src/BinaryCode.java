public class BinaryCode {

    private Integer[] A = {3,2,6,1,9};

    public void run() {

        int[] count = new int[10];
        for (Integer ele : A) {
            ++count[ele];
        }

        for (Integer i=1; i<count.length; ++i) {
            count[i] += count[i-1];
        }

        int[] sort = new int[A.length];
        for (Integer ele : A) {
            sort[count[ele] - 1]  = ele;
            --count[ele];
        }

        for (Integer ele : sort) {
            System.out.print(ele + " ");
        }

    }
}