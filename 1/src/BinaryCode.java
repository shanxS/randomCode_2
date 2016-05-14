public class BinaryCode {


    private final int FUEL = 0, DISTANCE = 1;
    private Integer[][] A = {{6, 4}, {3, 6}, {7, 3}};//{{4, 6}, {6, 5}, {7, 3}, {4, 5}};

    public void run() {

        int start = 0;
        int fuelLeft = A[start][FUEL] - A[start][DISTANCE];
        int thisPos = start;

        while (true) {

            if (fuelLeft < 0) {
                ++start;

                if (start < A.length) {
                    fuelLeft = A[start][FUEL] - A[start][DISTANCE];
                    thisPos = start;
                } else {

                    System.out.print("cant travel");
                    break;
                }

            } else {

                thisPos = (thisPos+1) % A.length;

                if (thisPos == start) {
                    System.out.print("travelled wiht start pos " + start);
                    break;
                }

                fuelLeft += A[thisPos][FUEL] - A[thisPos][DISTANCE];
            }
        }
    }

}