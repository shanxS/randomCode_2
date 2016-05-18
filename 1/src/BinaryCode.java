public class BinaryCode {

    private Integer[][] book;



    public void run() {

        int n=6, k=4;
        book = new Integer[n+1][k+1];

        System.out.println(find(n,k));

        for (int r=0; r<book.length; ++r) {
            System.out.println();
            for (int c=0; c<book[0].length; ++c) {
                System.out.print(book[r][c] + " ");
            }
        }



    }

    private int find(int n, int k) {
        if (n < 1 || k < 1 || k > n) {
            return -1;
        }

        if (book[n][k] != null) {
            return book[n][k];
        }

        if (k == n) {
            book[n][k] = 1;
        } else if (k==1) {
            book[n][k] = n;
        } else {
            book[n][k] = find(n - 1, k) + find(n - 1, k - 1);
        }

        return book[n][k];
    }

}