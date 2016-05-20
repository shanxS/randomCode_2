public class BinaryCode {

    private Integer[][] book;

    public void run() {

        int eggCount=20, floor=4000;

        book = new Integer[floor+1][eggCount+1];

        System.out.print(findMin(eggCount, floor));
    }

    private int findMin(int eggCount, int floor) {

        if (book[floor][eggCount] != null) {
            return book[floor][eggCount];
        }


        if (eggCount == 1) {
            book[floor][eggCount] = floor;
        } else if (floor == 0 || floor == 1) {
            book[floor][eggCount] = floor;
        } else {

            int min = Integer.MAX_VALUE;
            for (int thisFloor = 1; thisFloor <= floor; ++thisFloor) {
                min = Math.min(min,
                        Math.max(findMin(eggCount - 1, thisFloor - 1), findMin(eggCount, floor - thisFloor)));
            }

            book[floor][eggCount] = min + 1;
        }

        return book[floor][eggCount];

    }


}