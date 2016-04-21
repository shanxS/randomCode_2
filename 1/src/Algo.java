public class Algo {

    private Integer[] A = {4, 4, 100, 5000, 4, 4, 4, 4, 100, 100};

    public void run() {

        Integer xor = 0;
        for (Integer ele : A) {
            xor ^= ele;
        }

        Integer filter = xor & ~(xor-1);
        Integer num1 = 0;
        Integer num2 = 0;
        for (Integer ele : A) {
            if ((ele & filter) > 0) {
                num1 ^= ele;
            } else {
                num2 ^= ele;
            }
        }

        System.out.print(num1 + " " + num2);

    }
}