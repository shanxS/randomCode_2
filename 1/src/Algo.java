import java.util.*;

public class Algo {

    private Integer[] A = {-1,-1,
            1,-1,1,-1,
            1,1,
            1,1,1,-1,-1,-1,
            1,1,1
    };//{1,1,1,1,-1,1,-1,1,1};//{1, -1, 1, 1, 1, -1, -1};
    private Integer[] leftSum = new Integer[A.length];
    private Map<Integer, Integer> leftSumIndex = new HashMap<>();

    private Integer[] rightSum = new Integer[A.length];
    private Integer maxLen = Integer.MIN_VALUE;
    private Integer start, end;

    public void run() {

        init();

        coverCornerCases();


        System.out.print(maxLen + " " + start + " " + end);
    }

    private void coverCornerCases() {

        Integer total = rightSum[0];

        for (Integer rev = A.length-1; rev >= 0; --rev) {

            Integer right = rightSum[rev];
            Integer leftIndex = leftSumIndex.get(total - right);
            if (leftIndex != null && leftIndex < rev && maxLen < (rev-leftIndex-1)) {
                maxLen = (rev-leftIndex-1);
                start = leftIndex+1;
                end = rev-1;
            }

        }

    }

    private void init() {
        Integer fwd = 1, rev = A.length-2;
        leftSum[0] = A[0];
        rightSum[A.length-1] = A[A.length - 1];

        while (fwd < A.length && rev >= 0) {

            leftSum[fwd] = leftSum[fwd-1] + A[fwd];
            if (leftSumIndex.get(leftSum[fwd]) == null) {
                leftSumIndex.put(leftSum[fwd], fwd);
            }
            if (leftSum[fwd] == 0 && maxLen < (fwd+1)) {
                maxLen = fwd+1;
                start = 0;
                end = fwd;
            }

            rightSum[rev] = rightSum[rev+1] + A[rev];
            if (rightSum[rev] == 0 && maxLen < (A.length - rev)) {
                maxLen = A.length - rev;
                start = rev;
                end = A.length-1;
            }

            ++fwd;
            --rev;
        }
    }
}