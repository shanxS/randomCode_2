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

    Deque<Integer> que;
    private boolean[] visited;

    public void run() {
        que = new ArrayDeque<>();
        visited = new boolean[A.length];

        for (int i=2; i<visited.length+2; ++i) {
            int node = i%visited.length;
            if (!visited[node]) {
                que.addFirst(node);
                bfs(node);
            }
        }

    }

    private void bfs(int node) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;
        for (int i=0; i<visited.length; ++i) {
            if (!visited[i] && A[node][i] == 1) {
                que.addFirst(i);
            }
        }

        printBFS();
    }

    private void printBFS() {
        while (que.size() > 0) {
            int node = que.removeLast();
            System.out.print(node + " ");
            bfs(node);
        }
    }


}