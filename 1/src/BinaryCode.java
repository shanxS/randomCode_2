public class BinaryCode {

    private Integer[] A = {5,2,7,4,9};

    public void run() {

        Integer[] count = new Integer[10];
        for (Integer i=0; i<A.length; ++i) {
            Integer index = A[i];
            if (count[index] == null) {
                count[index] = 1;
            } else {
                ++count[index];
            }
        }

        for (Integer i=0; i<count.length; ++i) {
            if (count[i] == null) {
                if (i==0) {
                    count[i] = 0;
                } else {
                    count[i] = count[i-1];
                }
            } else if (i>0) {
                count[i] += count[i-1];
            }
        }

        Integer[] sorted = new Integer[A.length];
        for (Integer i=0; i<A.length; ++i) {
            sorted[count[A[i]]-1] = A[i];
        }

        for (Integer ele : sorted) {
            System.out.print(ele + " ");
        }

    }
}