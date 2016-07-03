import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {
        Algo algo = new Algo();
        algo.run();
    }

}

class Algo {

    private final int I = Integer.MAX_VALUE;
    private int[][] A = {
            {0,I,I,I,I,I},
            {I,0,I,I,I,I},
            {I,I,0,1,I,I},
            {I,1,I,0,I,I},
            {1,1,I,I,0,I},
            {1,I,1,I,I,0}


    };

    private boolean[] visited;
    private int nodeCount;
    private Deque<Integer> stack;

    public void run() {
        nodeCount = A.length;
        visited = new boolean[nodeCount];
        stack = new ArrayDeque<>();

        for (int i=0; i<nodeCount; ++i) {
            if (!visited[i]) {
                topo(i);
            }
        }

        while (stack.size() > 0) {

            System.out.print(stack.removeFirst() + " ");

        }
    }

    private void topo(int node) {
        visited[node] = true;

        for (int i=0; i<nodeCount; ++i) {
            if (!visited[i] && A[node][i] != I && node != i) {
                topo(i);
            }
        }

        stack.addFirst(node);
    }

}