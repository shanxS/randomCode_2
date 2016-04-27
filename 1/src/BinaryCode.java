public class BinaryCode {

    private Integer[] A = {3, 1, 5, 90};
    private Integer target = 2;

    public void run() {

        if (delete()) {
            for (Integer i=0; i<A.length; ++i) {
                System.out.print(A[i] + " ");
            }
        } else {
            System.out.print("not found");
        }

    }

    private Boolean delete() {

        Integer[] tmp = new Integer[A.length-1];
        Boolean found = false;
        Integer writer = tmp.length-1;
        for (Integer reader=A.length-1; reader>=0; --reader) {

            if (reader == 0 && A[reader] != target) {
                break;
            }

            if (A[reader] == target) {
                found = true;
                break;
            } else {
                tmp[writer] = A[reader];
            }

            --writer;

        }


        if (found) {
            while (writer >= 0) {
                tmp[writer] = A[writer];
                --writer;
            }

            A = tmp;
        }

        return found;
    }
}