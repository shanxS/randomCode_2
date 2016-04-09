import java.util.*;

/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] A = {5,  2,  2,  8,  5,  6,  8,  8};

    public void run() {
        Map<Integer, Integer> keyFreq = new HashMap<>();
        Map<Integer, List<Integer>> freqKeys = new LinkedHashMap<>();

        for (Integer i=0; i<A.length; ++i) {
            Integer key = A[i];

            Integer freq = keyFreq.get(key);
            if (freq == null) {
                freq = 0;
            }
            ++freq;
            keyFreq.put(key, freq);

            List<Integer> keys = freqKeys.get(freq);
            if (keys == null) {
                keys = new ArrayList<>();
                freqKeys.put(freq, keys);
            }
            keys.add(key);

            if (freq > 1) {
                List<Integer> oldKeys = freqKeys.get(freq - 1);
                oldKeys.remove(key);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : freqKeys.entrySet()) {
            final Integer freq = entry.getKey();
            List<Integer> keys = entry.getValue();

            for (Integer key : keys) {
                Integer counter = freq;
                while (counter > 0) {
                    System.out.print(key + " ");
                    --counter;
                }
            }
        }

        System.out.println(freqKeys);
        System.out.println(keyFreq);
    }
}
