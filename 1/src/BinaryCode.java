import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class BinaryCode {

    private Integer[] A1 = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
    private Integer[] A2 = {2, 1, 8, 3};
    private Map<Integer, Integer> numCounter;

    public void run() {
        Arrays.sort(A1, new CustomCompartor(A2));
        for (Integer ele : A1) {
            System.out.print(ele + " ");
        }
    }
}

class CustomCompartor implements Comparator<Integer> {

    private Map<Integer, Integer> map;

    public CustomCompartor(Integer[] A2) {
        map = new TreeMap<>();
        for (Integer i=0; i<A2.length; ++i) {
            map.put(A2[i], i);
        }

    }

    @Override
    public int compare(Integer num1, Integer num2) {
        if (map.containsKey(num1) && map.containsKey(num2)) {
            return map.get(num1).compareTo(map.get(num2));
        } else if (map.containsKey(num1) && !map.containsKey(num2)) {
            return -1;
        } else if (!map.containsKey(num1) && map.containsKey(num2)) {
            return 1;
        } else {
            return num1.compareTo(num2);
        }
    }
}