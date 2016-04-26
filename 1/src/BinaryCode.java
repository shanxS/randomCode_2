public class BinaryCode {

    private String str = "aabaacaabaa";
    private Integer interimPos = null;
    private Character interim = null;
    private Integer fHash = 0;
    private Integer sHash = 0;

    public void run() {

        for (Integer i=0; i<str.length(); ++i) {

            Character c = str.charAt(i);

            updateHash(c, i);

            System.out.println(c + " " + ((fHash.equals(sHash) || sHash.equals(0)) ? "yes" : "no") + " " + fHash + " " + sHash);

        }

    }

    private void updateHash(Character c, Integer pos) {

        final Integer PRIME = 31;

        if (fHash == 0) {
            fHash = PRIME * ((int) c);
        } else if (sHash == 0) {
            sHash = PRIME * ((int) c);
        } else {
            Integer midPos = pos/2;

            if (interim != null) {
                fHash += PRIME * ((int) interim);
                fHash += PRIME * interimPos;

                interim = null;
                interimPos = null;

                sHash += PRIME * (pos-midPos-1);
            } else {

                interim = str.charAt(midPos);
                interimPos = midPos;

                sHash -= PRIME * ((int)interim);
            }

            sHash += PRIME * ((int)c);

        }

    }


}