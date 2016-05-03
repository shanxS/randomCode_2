public class BinaryCode {

    private int[] A = {170, 450, 75, 90, 802, 24, 2, 66};
    private Integer pass;

    public void run() {

        initPass();

        Integer thisPass = 0;
        while (thisPass < pass) {
            int[] sorted = sortFor(thisPass);
            A = sorted;
            ++thisPass;
        }

        for (Integer ele : A) {
            System.out.print(ele + " ");
        }

    }

    private int[] sortFor(Integer thisPass) {
        int[] count = new int[10];
        for (Integer i=0; i<A.length; ++i) {
            ++count[getIndex(A[i], thisPass)];
        }

        for (Integer i=1; i<count.length; ++i) {
            count[i] += count[i-1];
        }

        int[] sorted = new int[A.length];
        for (Integer i=A.length-1; i>=0; --i) {
            sorted[count[getIndex(A[i], thisPass)] - 1] = A[i];
            --count[getIndex(A[i], thisPass)];
        }


        return sorted;
    }

    private int getIndex(int value, Integer pass) {
        value /= (int) Math.pow(10, pass);
        return value % 10;
    }

    public void initPass() {
        Integer max = Integer.MIN_VALUE;
        for (Integer ele : A) {
            max = Math.max(ele, max);
        }

        pass = 0;
        while (max != 0) {
            max /= 10;
            ++pass;
        }
    }

}