public class BinaryCode {

    private Integer[] A = {2, 0, 1, 4, 5, 3};
    private final Integer BIG = (int)10e4;
    public void run() {

        for (Integer i=0; i<A.length; ++i) {
            Integer j = getOrig(A[i]);
            if (j>=0 && j<A.length) {
                A[j] = encrypt(getOrig(A[j]), i);
            }
        }

        for (Integer i=0; i<A.length; ++i) {
            System.out.print(getEncrypt(A[i]) + " ");
        }
    }


    private Integer encrypt(Integer value, Integer data) {
        return value + (data*BIG);
    }

    private Integer getOrig(Integer value) {
        return (value%BIG);
    }

    private Integer getEncrypt(Integer value) {
        return (value/BIG);
    }

}