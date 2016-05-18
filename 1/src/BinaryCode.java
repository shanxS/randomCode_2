public class BinaryCode {

    private Integer[][] book;



    public void run() {

        int n=6, k=4;
        book = new Integer[n][k];

        System.out.print(find(n,k));

    }

    private int find(int n, int k) {
        if (n < 1 || k < 1 || k > n) {
            return -1;
        }

        if (k == n) {
            return 1;
        }

        if (k==1) {
            return n;
        }

        return find(n-1, k) + find(n-1, k-1);
    }

}