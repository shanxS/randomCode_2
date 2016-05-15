public class BinaryCode {

    private String s1 = "sunday";
    private String s2 = "saturday";
    private int counter = 0;

    private Integer[][] book = new Integer[s1.length()][s2.length()];

    public void run() {

        System.out.println(editDistance(s1.length()-1, s2.length()-1));
        System.out.println(counter);

    }

    private int editDistance(int len1, int len2) {
        if (len1 < 0 || len2 < 0) {
            return Math.max(len1, len2) + 1;
        }

        if (book[len1][len2] != null) {
            return book[len1][len2];
        }

        ++counter;

        if (s1.charAt(len1) == s2.charAt(len2)) {
            book[len1][len2] =  editDistance(len1-1, len2-1);
        } else {
            book[len1][len2] = 1 + Math.min(editDistance(len1, len2-1), Math.min(editDistance(len1-1, len2), editDistance(len1-1, len2-1)));
        }

        return book[len1][len2];
    }

}