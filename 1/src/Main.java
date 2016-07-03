import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Algo algo = new Algo();
        algo.run();
    }
}

class Algo {
    private final int I = Integer.MAX_VALUE;
    private int[][] A = {
          // 0 1 2 3 4 5 6
            {0,5,6,9,1,I,I}, // 0
            {I,0,3,I,3,2,1}, // 1
            {I,I,0,1,I,I,I}, // 2
            {8,I,I,0,I,I,I}, // 3
            {I,I,1,I,0,I,I}, // 4
            {I,I,I,I,I,0,I}, // 5
            {I,I,I,I,I,I,0}  // 6

    };

    private int nodeCount;
    private Integer[][] minDist;

    public void run() {

        nodeCount = A.length;
        minDist = new Integer[A.length][A.length];

        for (int src = 0; src < nodeCount; ++src) {
            for (int target=0; target<nodeCount; ++target) {
                if (src != target) {
                    int min = A[src][target];

                    for(int i=0; i<nodeCount; ++i) {
                        if (i!=target && i!= src && A[src][i] != I) {
                            boolean[] visited = new boolean[nodeCount];
                            visited[src] = true;
                            min = Math.min(min, findMinCost(src, target, visited, i, A[src][i]));
                        }
                    }
                    minDist[src][target] = min;
                    System.out.println("src " + src + " target " + target + " minDist " + min);
                }
            }
        }

    }

    private int findMinCost(int src, int target, boolean[] visited, int thisNode, int costSoFar) {

        if (thisNode == target) {
            return costSoFar;
        }

        int min;
        if (minDist[thisNode][target] != null && minDist[thisNode][target] != I ) {
            min = minDist[thisNode][target];
        } else {

            min = A[thisNode][target];
            for (int subNode = 0; subNode < nodeCount; ++subNode) {
                if (!visited[subNode] && A[thisNode][subNode] != I) {
                    boolean[] thisVisited = Arrays.copyOf(visited, visited.length);
                    thisVisited[subNode] = true;
                    min = Math.min(min, findMinCost(src, target, thisVisited, subNode, A[thisNode][subNode]));
                }
            }

            minDist[thisNode][target] = min;
        }

        return (min == I) ? I : min + costSoFar;
    }


}








