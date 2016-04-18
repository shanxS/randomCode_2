import java.util.HashMap;
import java.util.Map;

public class Algo {

    private Integer[][] A = {
            {2, 5, 7, 11, 15 },
            {1, 3},
            {6, 8, 12, 13, 14}
    };

    private Integer medianPos;
    private Map<Integer, Integer> indexCounterMap;


    public void run() {

        init();

        process();
    }

    private void process() {

        Integer winner = 0;

        while (medianPos >= 0) {
            Map<Integer, Integer> competitors = getCompetitors();
            winner = compete(competitors);

            --medianPos;
        }

        System.out.print(winner);
    }

    private Integer compete(Map<Integer, Integer> competitors) {
        Integer winner = Integer.MAX_VALUE;
        Integer index = null;
        for (Map.Entry<Integer, Integer> entry : competitors.entrySet()) {
            if (winner > entry.getValue()) {
                winner = entry.getValue();
                index = entry.getKey();
            }
        }

        indexCounterMap.put(index, (indexCounterMap.get(index) + 1));

        return winner;
    }

    private void init() {
        medianPos = 0;
        indexCounterMap = new HashMap<>();
        for (Integer i=0; i<A.length; ++i) {
            medianPos += A[i].length;
            indexCounterMap.put(i, 0);
        }
        medianPos /= 2;
    }


    public Map<Integer,Integer> getCompetitors() {
        Map<Integer,Integer> competitors = new HashMap<>();

        for (Integer i=0; i<A.length; ++i) {
            if (indexCounterMap.get(i) < A[i].length) {
                competitors.put(i, A[i][indexCounterMap.get(i)]);
            }
        }

        return competitors;
    }
}

