public class Algo {

    private final int INF = Integer.MAX_VALUE;
    private int[][] A = {
            {0,    5,  INF, 10},
            {INF,  0,  3,  INF},
            {INF, INF, 0,   1},
            {INF, INF, INF, 0}
    };


    private int[][] dist = new int[A.length][A[0].length];

    public void run() {

        for (int i=0; i<A.length; ++i) {
            for (int j=0; j<A.length; ++j) {
                dist[i][j] = INF;
            }
        }

        for (int start=0; start<A.length; ++start) {
            for (int dest=0; dest<A.length; ++dest) {
                compute(start, dest);
            }
        }

        for (int i=0; i<A.length; ++i) {
            System.out.println();
            for (int j=0; j<A.length; ++j) {
                System.out.print(dist[i][j] + " ");
            }
        }
    }

    private int compute(int start, int dest) {
        if (A[start][dest] == INF) {
            return INF;
        }


        if (A[start][dest] < INF) {
            dist[start][dest] = Math.min(A[start][dest], dist[start][dest]);

            for (int nextDest = dest+1; nextDest<A.length; ++nextDest) {
                dist[start][nextDest] = Math.min(dist[start][nextDest],
                        dist[start][dest] + compute(dest, nextDest));
            }
        }

        return dist[start][dest];

    }
}