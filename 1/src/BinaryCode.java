public class BinaryCode {

    private int[] S = {2, 5, 3, 6};
    private int counter = 0;
    private final int N = 10;
    private Integer[][] book = new Integer[S.length][N+1];

    public void run() {

        System.out.println((findCount(0, N-1) + findCount(1, N)));
        System.out.println(counter);

    }

    private int findCount(int index, int target) {

        if (target == 0) {
            return 1;
        } else if (index >= S.length || target < 0) {
            return 0;
        }

        if (book[index][target] != null) {
            return book[index][target];
        }

        ++counter;

        book[index][target] =  findCount(index, target-S[index])
                + findCount(index+1, target);

        return book[index][target];
    }

}