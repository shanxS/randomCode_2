import java.util.*;

public class Main {
    public static void main(String[] args) {
        Algo algo = new Algo();
        algo.run();
    }
}

class Algo {
    private int[][] A = {
            {0,1,1,0},
            {0,0,1,0},
            {1,0,0,1},
            {0,0,0,1}
    };

    private Deque<Integer> que;
    private boolean[] visited;

    public void run() {
        que = new ArrayDeque<>();
        visited = new boolean[A.length];

        for (int i=2; i<visited.length+2; ++i) {
            int node = i%visited.length;
            if (!visited[node]) {
                visited[node] = true;
                que.addFirst(node);
                bfs();
            }
        }
    }

    private void bfs() {
        while (que.size() > 0) {
            int node = que.removeLast();
            System.out.print(node + " ");
            for (int i=0; i<visited.length; ++i) {
                if (!visited[i] && A[node][i] == 1) {
                    visited[i] = true;
                    que.addFirst(i);
                }
            }
        }
    }
}