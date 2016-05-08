public class BinaryCode {

    private Integer[] A = {100,10,5,15,10};

    public void run() {
        for (Integer i=0; i<A.length; ++i) {
            if ((i==0 && A[i] > A[i+1])
                    || (i==A.length-1 && A[i] > A[i-1])
                    || (i>0 && i<A.length-1 && A[i] > A[i-1] && A[i] > A[i+1])) {
                System.out.print(A[i]);
                break;
            }
        }
    }
}