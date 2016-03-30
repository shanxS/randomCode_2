import java.util.*;

/**
 * @author shashaku on 29/03/16.
 */
public class Algo {
    private Integer[] A =  {10, 2, 6, 6};
    private Integer target = 12;
    private HashMap<Integer, Integer> elements;

    public void run() {
        elements = new HashMap<Integer, Integer>();
        for (Integer element : A) {
            Integer valueCount = elements.get(element);
            if (valueCount == null) {
                valueCount = 0;
            }
            ++valueCount;
            elements.put(element, valueCount);
        }

        Integer count = 0;
        for (Integer element : A) {
            Integer diff = target - element;
            Integer diffCount = elements.get(diff);
            if (diffCount != null && diffCount > 0) {
                ++count;

                remove(diff);
                remove(element);
            }
        }

        System.out.print(count);
    }

    private void remove(Integer value) {
        Integer count = elements.get(value);
        elements.put(value, count - 1);
    }
}
