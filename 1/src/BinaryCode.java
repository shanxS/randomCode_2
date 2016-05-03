import java.util.*;

public class BinaryCode {

    List<Integer[]> women, men;
    Stack<Integer> freeMen;
    Map<Integer, Integer> womanMan;


    public void run() {
        init();

        while (freeMen.size() > 0) {
            Integer man = freeMen.pop();
            for (Integer choice : men.get(man)) {
                if (!womanMan.containsKey(choice)) {
                    womanMan.put(choice, man);

                    break;
                } else if (womanDumps(choice, man)) {
                    freeMen.push(womanMan.get(choice));
                    womanMan.put(choice, man);

                    break;
                }
            }
        }

        System.out.print(womanMan);
    }

    private void init() {

        men = new ArrayList<>();
        men.add(new Integer[] {3, 1, 2, 0});
        men.add(new Integer[] {1, 0, 2, 3});
        men.add(new Integer[] {0, 1, 2, 3});
        men.add(new Integer[] {0, 1, 2, 3});


        women = new ArrayList<>();
        women.add(new Integer[] {0, 1, 2, 3});
        women.add(new Integer[] {0, 1, 2, 3});
        women.add(new Integer[] {0, 1, 2, 3});
        women.add(new Integer[] {0, 1, 2, 3});

        freeMen = new Stack<>();
        freeMen.push(0); freeMen.push(1); freeMen.push(2); freeMen.push(3);

        womanMan = new HashMap<>();
    }

    private boolean womanDumps(Integer woman, Integer choice) {
        Integer currentChoice = womanMan.get(woman);
        Integer currentChoiceIndex = getIndex(women.get(woman), currentChoice);
        Integer offeredChoiceIndex = getIndex(women.get(woman), choice);

        return offeredChoiceIndex < currentChoiceIndex;
    }

    private Integer getIndex(Integer[] choiceList, Integer choice) {
        for (Integer i=0; i<choiceList.length; ++i) {
            if (choiceList[i] == choice) {
                return i;
            }
        }

        return null;
    }
}