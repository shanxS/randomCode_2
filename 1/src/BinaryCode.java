public class BinaryCode {

    private String s = "GEEKSFORGEEKS";

    public void run() {

        System.out.print(Math.max(findMaxPalinLength(1, ""+s.charAt(0)),
                findMaxPalinLength(1, "")));
    }

    private int findMaxPalinLength(int thisIndex, String strSoFar) {
        if (thisIndex >= s.length()) {
            if (isPalindrome(strSoFar)) {
                return strSoFar.length();
            } else {
                return -1;
            }
        }

        int thisLen = (isPalindrome(strSoFar)) ? strSoFar.length() : -1;
        return Math.max(thisLen,
                Math.max(findMaxPalinLength(thisIndex+1, strSoFar+s.charAt(thisIndex)),
                findMaxPalinLength(thisIndex+1, strSoFar)));
    }


    private boolean isPalindrome (String s) {
        int fwd = 0;
        int rev = s.length()-1;

        while (rev > fwd) {
            if (s.charAt(rev) != s.charAt(fwd)) {
                return false;
            }

            ++fwd;
            --rev;
        }

        return true;
    }


}