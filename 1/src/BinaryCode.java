public class BinaryCode {

    public void run() {

        int eggCount=2, floor=10;

        System.out.print(findMin(eggCount, floor));
    }

    private int findMin(int eggCount, int floor) {

        if (eggCount == 1) {
            return floor;
        }

        if (floor == 0 || floor == 1) {
            return floor;
        }

        int min = Integer.MAX_VALUE;
        for (int thisFloor=1; thisFloor<=floor; ++thisFloor) {
            min = Math.min(min,
                    Math.max(findMin(eggCount-1, thisFloor-1), findMin(eggCount, floor-thisFloor)));
        }

        return min+1;

    }


}