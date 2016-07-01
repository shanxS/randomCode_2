import java.util.*;

public class Main {
    public static void main(String[] args) {
        Algo algo = new Algo();
        algo.run();
    }
}

class Algo {
    private final int I = Integer.MAX_VALUE;
    private int[][] A = {
            {0,5,2,9,I,I,I},
            {I,0,3,I,3,2,1},
            {I,I,0,1,I,I,I},
            {8,I,I,0,I,I,I},
            {I,I,I,I,I,I,I},
            {I,I,I,I,I,I,I},
            {I,I,I,I,I,I,I}

    };

    private int[][] min;
    private boolean[] visited;


    public void run() {

        visited = new boolean[A.length];

        for (int i=0; i<visited.length; ++i) {
            if (!visited[i]) {
                bfs(i);
            }
        }
    }

    private void bfs(int node) {
        Deque<Integer> que = new ArrayDeque<>();
        que.addLast(node);
        visited[node] = true;

        while(que.size() > 0) {

            int thisNode = que.removeFirst();
            System.out.print(thisNode + " ");
            for(int child=0; child<visited.length; ++child) {
                if (!visited[child] && A[thisNode][child] != I && thisNode != child) {
                    visited[child] = true;
                    que.addLast(child);
                }
            }
        }
    }
}








