import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryCode {

    private List<Integer[]> arrays;
    private Map<Integer, Integer> arrayIndex;

    public void run() {
        init();

        List<Integer> list = new ArrayList<>();
        while (true) {

            Integer min = findMin();
            if (min == null) {
                break;
            } else {
                list.add(min);
            }

        }

        System.out.print(list);

    }

    private Integer findMin() {

        Integer min = null;
        Integer minArray = null;

        for (Map.Entry<Integer, Integer> entry : arrayIndex.entrySet()) {

            Integer array = entry.getKey();
            Integer index = entry.getValue();
            if (index < arrays.get(array).length) {

                if (min == null || min > arrays.get(array)[index]) {
                    min = arrays.get(array)[index];
                    minArray = array;
                }

            }

        }

        if (min != null) {
            arrayIndex.put(minArray, arrayIndex.get(minArray) + 1);
        }


        return min;
    }

    private void init() {
        arrays = new ArrayList<>();
        arrays.add(new Integer[]{2, 6, 12, 34});
        arrays.add(new Integer[]{1, 9, 20, 1000});
        arrays.add(new Integer[]{23, 34, 90, 2000});

        arrayIndex = new HashMap<>();
        arrayIndex.put(0, 0);
        arrayIndex.put(1, 0);
        arrayIndex.put(2, 0);
    }
}