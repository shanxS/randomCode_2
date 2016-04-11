public class Algo {

    private Integer[] A = {0, 1, 2, 6, };

    public void run() {
        Integer ele = 0;
        for (Integer foundEle : A) {
            if (foundEle != ele) {
                System.out.print("cant find " + ele);
                return;
            }

            ++ele;
        }

        System.out.print("found all");
    }

}