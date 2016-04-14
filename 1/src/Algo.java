import java.util.HashMap;
import java.util.Map;

public class Algo {

    private Integer[] A = {2, 5, 3, 5, 4, 4, 2, 3};
    private Map<Integer, Integer> map = new HashMap<>();
    private Integer key1 = 3, key2 = 2, minDistance = Integer.MAX_VALUE;

    public void run() {
        map.put(key1, null);
        map.put(key2, null);

        for (Integer i=0; i<A.length; ++i) {
            if (map.containsKey(A[i])) {
                map.put(A[i], i);

                Integer pos1 = map.get(key1);
                Integer pos2 = map.get(key2);
                if (pos1 != null && pos2 != null) {
                    minDistance = Math.min(minDistance, Math.abs(pos1 - pos2));
                }
            }
        }

        System.out.print(minDistance);
    }
}