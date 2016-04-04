import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    public void run() {
        Integer[] A = {1, 20, 6, 4, 5};//{2, 4, 1, 3, 5};
        InversionDetector id = new InversionDetector();
        System.out.print(id.findInversions(A));
    }
}

class InversionDetector {
    private Map<Integer, List<Integer>> inversions;
    private Integer[] A;

    public Map<Integer, List<Integer>> findInversions(Integer[] A) {
        inversions = new HashMap<>();
        this.A = A;

        divide(0, A.length-1);


        return inversions;
    }

    private void divide(Integer start, Integer end) {
        if (start == end) {
            return;
        }

        Integer start1 = start;
        Integer end1 = mean(start1, end);
        divide(start1, end1);

        Integer start2 = end1+1;
        Integer end2 = end;
        divide(start2, end2);

        findInversions(start1, end1, start2, end2);
    }

    private void findInversions(Integer start1, Integer end1, Integer start2, Integer end2) {
        Integer marker1 = start1;
        Integer marker2 = start2;

        Integer[] tempA = new Integer[(end1-start1+1) + (end2-start2+1)];
        Integer marker = 0;

        while (marker1 <= end1 && marker2 <= end2) {

            if (A[marker1] > A[marker2]) {
                registerInversion(marker1, marker2, end1);
                tempA[marker] = A[marker2];
                ++marker2;
            } else {
                tempA[marker] = A[marker1];
                ++marker1;
            }

            ++marker;
        }

        while (marker1 <= end1) {
            tempA[marker] = A[marker1];
            ++marker;
            ++marker1;
        }

        while (marker2 <= end2) {
            tempA[marker] = A[marker2];
            ++marker;
            ++marker2;
        }

        marker = 0;
        for (Integer i=start1; i<=end2; ++i, ++marker) {
            A[i] = tempA[marker];
        }
    }

    private void registerInversion(Integer offendedIndexStart, Integer responsibleIndex, Integer offendedIndexEnd) {

        for (Integer offendedIndex = offendedIndexStart; offendedIndex<=offendedIndexEnd; ++offendedIndex) {
            List<Integer> offenders = inversions.get(A[offendedIndex]);
            if (offenders == null) {
                offenders = new ArrayList<>();
                inversions.put(A[offendedIndex], offenders);
            }
            offenders.add(A[responsibleIndex]);
        }
    }

    private Integer mean(Integer num1, Integer num2) {
        return Math.min(num1, num2) + ((Math.abs(num1-num2))/2);
    }
}