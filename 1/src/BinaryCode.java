public class BinaryCode {

    private int[] A = {170, 45, 75, 90, 802, 24, 2, 66};

    public void run() {
        Integer passCount = getPassCount();

        Integer thisPass = 0;
        while (thisPass < passCount) {
            A = sortFor(thisPass);
            ++thisPass;
        }

        for (int ele : A) {
            System.out.print(ele + " ");
        }
    }

    private int[] sortFor(Integer thisPass) {
        int[] count = new int[10];
        for (int i=0; i<A.length; ++i) {
            ++count[getNumberFor(A[i], thisPass)];
        }

        for (int i=1; i<count.length; ++i) {
            count[i] += count[i-1];
        }

        int[] sort = new int[A.length];
        for (int i=A.length-1; i>=0; --i) {
            sort[count[getNumberFor(A[i], thisPass)] - 1] = A[i];
            --count[getNumberFor(A[i], thisPass)];
        }

        return sort;
    }

    private int getNumberFor(int num, int pass) {
        while (pass > 0) {
            num /= 10;
            --pass;
        }

        return num%10;
    }

    private Integer getPassCount() {
        Integer max = Integer.MIN_VALUE;
        for (Integer ele : A) {
            max = Math.max(max, ele);
        }

        int pass = 0;
        while (max > 0) {
            max /= 10;
            ++pass;
        }

        return pass;
    }


}