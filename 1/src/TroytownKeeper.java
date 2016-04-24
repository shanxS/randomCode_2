import java.util.Stack;

public class TroytownKeeper {

    private final Character WALL = '#';
    private final Character EMPTY = '.';

    private Boolean[][] visited;
    private Character[][] maze;

    int limeLiters(String[] strs) {


        init(strs);
        walkAndEvaluate();
        perimeter();

        return paint;


    }

    private void perimeter() {

        for (Integer r=0; r<maze.length; ++r) {
            if (maze[r][0] == WALL) {
                ++paint;
            }


            if (maze[r][maze[0].length-1] == WALL) {
                ++paint;
            }
        }

        for (Integer c=0; c<maze[0].length; ++c) {
            if (maze[0][c] == WALL) {
                ++paint;
            }

            if (maze[maze.length-1][c] == WALL) {
                ++paint;
            }

        }

    }

    private void walkAndEvaluate() {

        for (Integer r=0; r<maze.length; ++r) {
            if (!visited[r][0] && maze[r][0] == EMPTY) {
                evaluate(r, 0);
            }

            if (!visited[r][maze[0].length-1] && maze[r][maze[0].length-1] == EMPTY) {
                evaluate(r, maze[0].length-1);
            }
        }

        for (Integer c=0; c<maze[0].length; ++c) {
            if (!visited[0][c] && maze[0][c] == EMPTY) {
                evaluate(0, c);
            }

            if (!visited[maze.length-1][c] && maze[maze.length-1][c] == EMPTY) {
                evaluate(maze.length-1, c);
            }

        }

    }

    private Stack<Spot> spot = new Stack<>();
    private void evaluate(Integer r, Integer c) {
        spot.push(new Spot(r,c));

        while (spot.size() > 0) {
            dfs(spot.pop());
        }
    }

    private Integer paint = 0;
    private void dfs(Spot thisSpot) {

        Integer r = thisSpot.r;
        Integer c = thisSpot.c;

        if (visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        if (wall(top(r, c))) {
            ++paint;
        }
        if (wall(bottom(r, c))) {
            ++paint;
        }
        if (wall(left(r, c))) {
            ++paint;
        }
        if (wall(right(r, c))) {
            ++paint;
        }

        if (empty(top(r, c))) {
            spot.push(top(r,c));
        }
        if (empty(bottom(r, c))) {
            spot.push(bottom(r,c));
        }
        if (empty(left(r, c))) {
            spot.push(left(r,c));
        }
        if (empty(right(r, c))) {
            spot.push(right(r,c));
        }

    }

    private boolean wall(Spot spot) {
        if (notValid(spot) || maze[spot.r][spot.c] != WALL) {
            return false;
        }

        return true;
    }

    private Boolean empty(Spot spot) {
        if (notValid(spot) || maze[spot.r][spot.c] != EMPTY) {
            return false;
        }

        return true;
    }

    private boolean notValid(Spot spot) {
        return (spot.r < 0 || spot.r >= maze.length)
                ||  (spot.c < 0 || spot.c >= maze[0].length);
    }

    private Spot right(Integer r, Integer c) {
        return new Spot(r, c+1);
    }

    private Spot left(Integer r, Integer c) {
        return new Spot(r, c-1);
    }

    private Spot bottom(Integer r, Integer c) {
        return new Spot(r+1, c);
    }

    private Spot top(Integer r, Integer c) {
        return new Spot(r-1, c);
    }


    private void init (String[] strs) {
        maze = new Character[strs.length][strs[0].length()];
        visited = new Boolean[maze.length][maze[0].length];

        Integer row = 0;
        for (String str : strs) {
            for (Integer col = 0; col<str.length(); ++col) {
                maze[row][col] = str.charAt(col);
                visited[row][col] = false;
            }
            ++row;
        }

//        for (Character[] mazeRow : maze) {
//            for (Character ele : mazeRow) {
//                System.out.print(ele + " ");
//            }
//            System.out.println();
//        }
    }


    class Spot {

        public Integer r, c;

        public Spot(Integer r, Integer c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Spot)) return false;

            Spot spot = (Spot) o;

            if (r != null ? !r.equals(spot.r) : spot.r != null) return false;
            return !(c != null ? !c.equals(spot.c) : spot.c != null);

        }

        @Override
        public int hashCode() {
            int result = r != null ? r.hashCode() : 0;
            result = 31 * result + (c != null ? c.hashCode() : 0);
            return result;
        }
    }

}

