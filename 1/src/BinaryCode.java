import lombok.AllArgsConstructor;
import lombok.ToString;

public class BinaryCode {

    private Integer[] A = {-2, -5, 6, -2, -3, 1, 5, -6};
    private int[][] results = new int[A.length][A.length];

    public void run() {

        ;
        System.out.print(findMaxIn(0, A.length-1).toString());

    }

    private Data findMaxIn(int start, int end) {
        if (start > end) {
            return new Data(start, end, Integer.MIN_VALUE);
        }

        if (start == end) {
            return new Data(start, end, A[start]);
        }

        int mid = Math.min(start, end) + ((Math.abs(start-end))/2);
        Data leftMax = findMaxIn(start, mid);
        Data rightMax = findMaxIn(mid+1, end);
        Data midMax = findMidMax(start, mid, end);

        if (midMax.value > leftMax.value && midMax.value > rightMax.value) {
            return midMax;
        } else if (leftMax.value > rightMax.value) {
            return leftMax;
        } else {
            return rightMax;
        }

    }

    private Data findMidMax(int start, int mid, int end) {
        int sum = 0;
        int leftMax = 0;
        int leftStart = -1;
        for (int i=mid; i>=start; --i) {
            sum += A[i];
            if (leftMax < sum) {
                leftMax = sum;
                leftStart = i;
            }
        }

        sum = 0;
        int rightMax = 0;
        int rightEnd = -1;
        for (int i=mid+1; i<=end; ++i) {
            sum += A[i];
            if (rightMax < sum) {
                rightMax = sum;
                rightEnd = i;
            }
        }

        return new Data(leftStart, rightEnd, rightMax + leftMax);
    }
}

@ToString
@AllArgsConstructor
class Data {
    public int start, end, value;
}