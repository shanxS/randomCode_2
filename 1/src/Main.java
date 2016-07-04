import java.util.*;

public class Main {
    public static void main(String[] arg) {
        Algo algo = new Algo();
        algo.run();
    }
}

class Algo {

    private int[][] A = {
            {0,1,1},
            {1,0,1},
            {1,0,0}
    };
    private Set<Integer> black, white;
    private final int BLACK = 0, WHITE = 1, CONNECTED = 1;
    private int nodeCount;

    public void run() {
        black = new HashSet<>();
        white = new HashSet<>();

        nodeCount = A.length;
        for (int i=0; i<nodeCount; ++i) {
            if (!isBipartite(i)) {
                System.out.print("broke at " + i);
                break;
            }
        }
    }

    private boolean isBipartite(int node) {
        if (black.contains(node) && white.contains(node)) {
            return false;
        }

        Integer color = null;
        if (black.contains(node)) {
            color = BLACK;
        } else if (color == null && white.contains(node)) {
            color = WHITE;
        } else {
            color = BLACK;
            black.add(node);
        }

        for (int child=0; child<nodeCount; ++child) {
            if (A[node][child] == CONNECTED) {
                Integer childColor = getPreAssignedColor(child);
                if (childColor == null) {
                    addToOppositeSet(child, color);
                } else if (childColor.equals(color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private void addToOppositeSet(int node, int color) {
        if (color == BLACK) {
            white.add(node);
        } else {
            black.add(node);
        }
    }

    private Integer getPreAssignedColor(int node) {
        if (black.contains(node)) {
            return BLACK;
        } else if (white.contains(node)) {
            return WHITE;
        } else {
            return null;
        }
    }

}














