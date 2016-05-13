import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinaryCode {

    private String[] A = {"1", "34", "3", "98", "9", "76", "45", "4"};

    public void run() {
        List<String> list = Arrays.asList(A);

        Collections.sort(list, (x,y) -> {
            return (x+y).compareTo(y+x);
        });

        System.out.print(list);
    }

}