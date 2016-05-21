public class BinaryCode {

    private String s = "BBABCBCAB";

    public void run() {

        System.out.print(findMaxPalnLength(0, s.length()-1));

    }

    private int findMaxPalnLength(int start, int end) {
        if (start == end) {
            return 1;
        } else if (start > end) {
            return 0;
        } else {

            if (s.charAt(start) == s.charAt(end)) {
                return 2 + findMaxPalnLength(start + 1, end - 1);
            } else {
                return Math.max(findMaxPalnLength(start + 1, end),
                        findMaxPalnLength(start, end - 1));
            }
        }
    }


}