import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryCode {

    private Integer[] A = {2, 5, 2, 8, 5, 7, 6, 8, 8};
    private Map<Integer, Integer> numberPos, numberFreq;
    private Map<Integer, List<Integer>> freqNumbers;

    public void run() {

        numberPos = new HashMap<>();
        numberFreq = new HashMap<>();
        freqNumbers = new HashMap<>();

        for (Integer i=0; i<A.length; ++i) {
            Integer num = A[i];

            if (numberPos.get(num) == null) {
                numberPos.put(num, i);
            }

            Integer freq = numberFreq.get(num);
            if (freq == null) {
                freq = 0;
            }
            ++freq;
            numberFreq.put(num, freq);

            List<Integer> numbers = freqNumbers.get(freq);
            if (numbers == null) {
                numbers = new ArrayList<>();
                freqNumbers.put(freq, numbers);
            }
            numbers.add(num);

        }

        Integer[] sorted = new Integer[A.length];
        Integer marker = 0;
        for (Map.Entry<Integer, List<Integer>> entry : freqNumbers.entrySet()) {
            for (Integer num : entry.getValue()) {
                if (numberFreq.get(num) != entry.getKey()) {
                    continue;
                }

                Integer count = entry.getKey();
                while (count > 0) {
                    sorted[marker] = num;
                    ++marker;
                    --count;
                }
            }
        }

        for (Integer ele : sorted) {
            System.out.print(ele + " ");
        }

    }
}