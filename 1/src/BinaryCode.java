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
                    count += countFor(r,c);
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


        while (rStack.size() > 0 && cStack.size() > 0) {
            up(r, c, rStack, cStack);
            down(r, c, rStack, cStack);
            left(r, c, rStack, cStack);
            right(r, c, rStack, cStack);

            leftUp(r, c, rStack, cStack);
            leftDown(r, c, rStack, cStack);
            rightUp(r, c, rStack, cStack);
            rightDown(r, c, rStack, cStack);

            visited[r][c] = true;
            r=rStack.pop();
            c=cStack.pop();

        }

        return 1;

    }

    private void rightDown(Integer r, Integer c, Stack<Integer> rStack, Stack<Integer> cStack) {
        if (isValid(r+1, c+1) && A[r+1][c+1] == 1) {
            rStack.push(r+1);
            cStack.push(c+1);
        }
    }

    private boolean isValid(int r, int c) {
        return (r >=0 && r<A.length)
                && (c>=0 && c<A[0].length) && !visited[r][c];
    }

    private void rightUp(Integer r, Integer c, Stack<Integer> rStack, Stack<Integer> cStack) {
        if (isValid(r-1, c+1) && A[r-1][c+1] == 1) {
            rStack.push(r-1);
            cStack.push(c+1);
        }
    }

    private void leftDown(Integer r, Integer c, Stack<Integer> rStack, Stack<Integer> cStack) {
        if (isValid(r+1, c-1) && A[r+1][c-1] == 1) {
            rStack.push(r+1);
            cStack.push(c-1);
        }
    }

    private void leftUp(Integer r, Integer c, Stack<Integer> rStack, Stack<Integer> cStack) {
        if (isValid(r-1, c-1) && A[r-1][c-1] == 1) {
            rStack.push(r-1);
            cStack.push(c-1);
        }
    }

    private void right(Integer r, Integer c, Stack<Integer> rStack, Stack<Integer> cStack) {
        if (isValid(r, c+1) && A[r][c+1] == 1) {
            rStack.push(r);
            cStack.push(c+1);
        }
    }

    private void left(Integer r, Integer c, Stack<Integer> rStack, Stack<Integer> cStack) {
        if (isValid(r, c-1) && A[r][c-1] == 1) {
            rStack.push(r);
            cStack.push(c-1);
        }
    }

    private void down(Integer r, Integer c, Stack<Integer> rStack, Stack<Integer> cStack) {
        if (isValid(r+1, c) && A[r+1][c] == 1) {
            rStack.push(r+1);
            cStack.push(c);
        }
    }

    private void up(Integer r, Integer c, Stack<Integer> rStack, Stack<Integer> cStack) {
        if (isValid(r-1, c) && A[r-1][c] == 1) {
            rStack.push(r-1);
            cStack.push(c);
        }
    }
}