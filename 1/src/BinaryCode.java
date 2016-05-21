public class BinaryCode {

    private String s = "BBABCBCAB";
    private int count = 0;
    private Integer[][] book = new Integer[s.length()][s.length()];

    public void run() {

        System.out.print(findMaxPalnLength(0, s.length()-1) + " " + count);

    }

    private int findMaxPalnLength(int start, int end) {
        if (book[start][end] != null) {
            return book[start][end];
        }

        if (start > end) {
            return 0;
        }

        ++count;
        if (start == end) {
            book[start][end] = 1;
        } else {

            if (s.charAt(start) == s.charAt(end)) {
                book[start][end] = 2 + findMaxPalnLength(start + 1, end - 1);
            } else {
                book[start][end] = Math.max(findMaxPalnLength(start + 1, end),
                        findMaxPalnLength(start, end - 1));
            }
        }

        return book[start][end];
    }


}