import java.util.Map;
import java.util.TreeMap;

public class BinaryCode {

    private Integer[] A1 = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
    private Integer[] A2 = {2, 1, 8, 3};
    private Map<Integer, Integer> numCounter;

    public void run() {
        numCounter = new TreeMap<>();
        for (Integer ele : A1) {
            Integer count = numCounter.get(ele);
            if (count == null) {
                count=0;
            }
            ++count;
            numCounter.put(ele, count);
        }

        for (Integer ele : A2) {
            Integer count = numCounter.get(ele);
            if (count != null) {
                numCounter.remove(ele);
                while (count > 0) {
                    System.out.print(ele + " ");
                    --count;
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : numCounter.entrySet()) {
            Integer ele = entry.getKey();
            Integer count = entry.getValue();
            while (count > 0) {
                System.out.print(ele + " ");
                --count;
            }
        }
    }
}