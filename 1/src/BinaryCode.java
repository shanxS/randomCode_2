public class BinaryCode {

    private int[] A = {170, 45, 75, 90, 802, 24, 2, 66};

    public void run() {

        Integer passCount = getPassCount();

        Integer counter = 0;
        while (counter < passCount) {
            A = sortForPass(counter);

            for (int ele : A) {
                System.out.print(ele + " ");
            }

            System.out.println();
            ++counter;
        }

        System.out.println();
        for (int ele : A) {
            System.out.print(ele + " ");
        }

    }

    private int[] sortForPass(Integer pass) {
        int[] count = new int[10];
        for (Integer i=0; i<A.length; ++i) {
            ++count[getNumberforPass(A[i], pass)];
        }

        for (Integer i=1; i<count.length; ++i) {
            count[i] += count[i-1];
        }

        int[] sort = new int[A.length];
        for (Integer i=A.length-1; i>=0; --i) {
            sort[count[getNumberforPass(A[i], pass)] - 1] = A[i];
            --count[getNumberforPass(A[i], pass)];
        }

        return sort;
    }

    private Integer getNumberforPass(Integer number, Integer pass) {
        number /= (int) Math.pow(10, pass);
        return number%10;
    }

    public Integer getPassCount() {
        Integer max = Integer.MIN_VALUE;
        for (Integer ele : A) {
            max = Math.max(ele, max);
        }

        Integer pass = 0;
        while (max > 0) {
            max /= 10;
            ++pass;
        }

        return pass;
    }
}