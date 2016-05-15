public class BinaryCode {

    private char[] A1 = {'A','G', 'G', 'T', 'A', 'B'};
    private char[] A2 = {'G', 'X', 'T', 'X', 'A', 'Y', 'B'};
    private int counter = 0;

    private Integer[][] book = new Integer[A1.length][A2.length];

    public void run() {

        System.out.println(findFor(A1.length-1, A2.length-1));
        System.out.println(counter);

    }

    private int findFor(int len1, int len2) {


        if (len1 < 0 || len2 < 0) {
            return 0;
        } else if (book[len1][len2] != null) {
            return book[len1][len2];
        } else {

            int result;

            ++counter;

            if (A1[len1] == A2[len2]) {
                result = 1 + findFor(len1 - 1, len2 - 1);
            } else {
                result = Math.max(findFor(len1 - 1, len2), findFor(len1, len2 - 1));
            }

            book[len1][len2] = result;
            return result;
        }
    }

}