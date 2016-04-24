public class BinaryCode {

    private final String NONE = "NONE";
    private final String ONE = "1";
    private final String ZERO = "0";

    public String[] decode(String message) {
        String res1 = decode("1", message);
        String res2 = decode("0", message);

        return new String[] {res1, res2};
    }

    private String decode(String start , String message) {

        String result = "";

        Integer next = 0;
        for (Integer i=0; i<message.length(); ++i) {
            if (i==0) {
                result = start;
                next = toInt(message.charAt(i)) - toInt(start);
            } else {
                result += next.toString();
                next = toInt(message.charAt(i)) - (toInt(result.charAt(i-1)) + toInt(result.charAt(i)) );
            }

            if (next < 0 || next > 1) {
                return NONE;
            }
        }


        return result;

    }

    private Integer toInt(String start) {
        return Integer.parseInt(start);
    }

    private Integer toInt(Character c) {
        return Character.getNumericValue(c);
    }
}