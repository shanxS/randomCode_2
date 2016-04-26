public class BinaryCode {

    private String str = "aabaacaabaa";
    private Character interim = null;
    private Integer interimPos = null;
    private Integer fHash = 0;
    private Integer lHash = 0;

    public void run() {


        for (Integer i=0; i<str.length(); ++i) {
            Character c = str.charAt(i);

            updateHash(c, i);

            System.out.println("character " + c + " " + ((int)c) + " " + (((fHash.equals(lHash)) || (lHash == 0)) ? "yes" : "no") + " " + fHash + " " + lHash);

        }
    }

    private void updateHash(Character c, Integer pos) {

        final Integer PRIME = 31;

        if (fHash == 0) {
            fHash = PRIME * ((int) c);
        } else if (lHash == 0) {
            lHash = PRIME * ((int) c);
        } else {
            Integer midPos = pos/2;

            if (interim != null) {

                fHash += PRIME * ((int) interim);
                fHash += PRIME * interimPos;
                interim = null;
                interimPos = null;

                lHash += PRIME * (pos-midPos-1);
            } else {

                Character midChar = str.charAt(midPos);
                lHash -= PRIME * ((int) midChar);

                interimPos = midPos;
                interim = midChar;

            }

            lHash += PRIME * ((int) c);
        }

    }
}
