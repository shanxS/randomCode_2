import java.util.Stack;

public class BinaryCode {

    private Integer[][] A = {
            {1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1}};

    private boolean[][] visited = new boolean[A.length][A[0].length];

    public void run() {

        Integer count = 0;

        for (Integer r=0; r<A.length; ++r) {
            for (Integer c=0; c<A[0].length; ++c) {

                if (A[r][c] == 1 && !visited[r][c]) {
                    count += countFor(r, c);
                }

            }
        }

        System.out.print(count);
    }

    private Integer countFor(Integer r, Integer c) {
        Stack<Integer> rStack = new Stack<>();
        rStack.push(r);
        Stack<Integer> cStack = new Stack<>();
        cStack.push(c);


        while (rStack.size()>0 && cStack.size()>0) {

            up(r,c,rStack,cStack);
            down(r,c,rStack,cStack);
            left(r,c,rStack,cStack);
            right(r,c,rStack,cStack);

            upLeft(r,c,rStack,cStack);
            upRight(r,c,rStack,cStack);
            downLeft(r,c,rStack,cStack);
            downRight(r,c,rStack,cStack);

            visited[r][c] = true;
            r = rStack.pop();
            c = cStack.pop();
        }


        return 1;
    }

    private void downRight(Integer r, Integer c, Stack<Integer> rStack, Stack<Integer> cStack) {
        if (valid(r+1, c+1) && A[r+1][c+1] == 1) {
            rStack.push(r+1);
            cStack.push(c+1);
        }
    }

    private void downLeft(Integer r, Integer c, Stack<Integer> rStack, Stack<Integer> cStack) {
        if (valid(r+1, c-1) && A[r+1][c-1] == 1) {
            rStack.push(r+1);
            cStack.push(c-1);
        }
    }

    private void upRight(Integer r, Integer c, Stack<Integer> rStack, Stack<Integer> cStack) {
        if (valid(r-1, c+1) && A[r-1][c+1] == 1) {
            rStack.push(r-1);
            cStack.push(c+1);
        }
    }

    private void upLeft(Integer r, Integer c, Stack<Integer> rStack, Stack<Integer> cStack) {
        if (valid(r-1, c-1) && A[r-1][c-1] == 1) {
            rStack.push(r-1);
            cStack.push(c-1);
        }
    }

    private void right(Integer r, Integer c, Stack<Integer> rStack, Stack<Integer> cStack) {
        if (valid(r, c+1) && A[r][c+1] == 1) {
            rStack.push(r);
            cStack.push(c+1);
        }
    }

    private void left(Integer r, Integer c, Stack<Integer> rStack, Stack<Integer> cStack) {
        if (valid(r, c-1) && A[r][c-1] == 1) {
            rStack.push(r);
            cStack.push(c-1);
        }
    }

    private void down(Integer r, Integer c, Stack<Integer> rStack, Stack<Integer> cStack) {
        if (valid(r+1, c) && A[r+1][c] == 1) {
            rStack.push(r+1);
            cStack.push(c);
        }
    }

    private boolean valid(int r, Integer c) {
        return (r>=0 && r<A.length) && (c>=0 && c<A[0].length) && !visited[r][c];
    }

    private void up(Integer r, Integer c, Stack<Integer> rStack, Stack<Integer> cStack) {
        if (valid(r-1, c) && A[r-1][c] == 1) {
            rStack.push(r-1);
            cStack.push(c);
        }
    }

}