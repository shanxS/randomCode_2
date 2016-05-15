public class BinaryCode {

    private char[] A1 = {'A','G', 'G', 'T', 'A', 'B'};
    private char[] A2 = {'G', 'X', 'T', 'X', 'A', 'Y', 'B'};

    public void run() {

        System.out.print(findFor(A1.length-1, A2.length-1));

    }

    private int findFor(int len1, int len2) {

        if (len1 < 0 || len2 < 0) {
            return 0;
        }


        if (A1[len1] ==  A2[len2]) {
            return 1 + findFor(len1-1, len2-1);
        } else {
            return Math.max(findFor(len1-1, len2), findFor(len1, len2-1));
        }
    }

}