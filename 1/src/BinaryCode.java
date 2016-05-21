public class BinaryCode {

    private String s = "BBABCBCAB";

    public void run() {

        int max = Integer.MIN_VALUE;
        for (int startPoint = 0; startPoint<s.length(); ++startPoint) {
            max = Math.max(max, Math.max(
                    findMaxPalinLength(startPoint,startPoint),
                    findMaxPalinLength(startPoint-1, startPoint)));
        }

        System.out.print(max);
    }

    private int findMaxPalinLength(int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex >= s.length()) {
            return 0;
        } else if (startIndex == endIndex) {
            return 1 + findMaxPalinLength(startIndex-1, endIndex+1);
        }


        if (s.charAt(startIndex) == s.charAt(endIndex)) {

            return 2 + findMaxPalinLength(startIndex-1, endIndex+1);

        } else {

            return Math.max(findMaxPalinLength(startIndex, endIndex+1),
                    findMaxPalinLength(startIndex-1, endIndex));

        }
    }

}