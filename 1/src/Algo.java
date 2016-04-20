public class Algo {

    private Integer[] A = {10, 20};

    public void run() {

        Integer xor = A[0];
        for (Integer i=1; i<A.length; ++i) {
            xor ^= A[i];
        }

        Integer filter = xor & (~(xor-1));
        Integer num1 = 0;
        for (Integer ele : A) {
            if ((ele & filter) > 0) {
                num1 ^= ele;
            }
        }


        Integer num2 = 0;
        for (Integer ele : A) {
            if (((~ele) & filter) > 0) {
                num2 ^= ele;
            }
        }

        System.out.print(num1 + " " + (num2));
    }
}