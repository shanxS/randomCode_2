/**
 * @author shashaku on 29/03/16.
 */
public class Main {

    public static void main(String[] args) {




        BinaryCode binaryCode = new BinaryCode();
        String[] s = binaryCode.decode("22111");
        System.out.print(s[0] + " " + s[1]);
    }
}
