/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[][] ARR = {{1, 1, 1, 2, 2},
                             {1, 1, 2, 4, 4, 4, 6, 6},
                             {1, 2, 3, 3, 3, 3, 10},
            {1, 2, 3, 3, 3, 3, 10}};
    private Integer[] values = {1,4,3,10};

    public void run() {
        for (Integer i=0; i<ARR.length; ++i) {
            System.out.println("first " + firstIndex(values[i], ARR[i]));
            System.out.println("last " + lastIndex(values[i], ARR[i]));
            System.out.println();
        }

    }

    private Integer lastIndex(Integer value, Integer[] A) {
        Integer start = 0;
        Integer end = A.length-1;

        while (start <= end) {
            Integer mid = mean(start, end);
            if (A[mid] == value) {
                if(mid < A.length-1 && A[mid+1] == value) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            } else if (A[mid] < value) {
                start = start+1;
            } else if (A[mid] > value) {
                end = mid-1;
            }
        }

        return null;
    }

    private Integer firstIndex(Integer value, Integer[] A) {
        Integer start = 0;
        Integer end = A.length-1;

        while (start <= end) {
            Integer mid = mean (start, end);
            if (A[mid] == value) {
                if (mid > 0 && A[mid-1] == value) {
                    end = mid-1;
                } else {
                    return mid;
                }
            } else if (A[mid] < value) {
                start = mid + 1;
            } else if (A[mid] > value) {
                end = mid - 1;
            }
        }

        return null;
    }

    private Integer mean(Integer num1, Integer num2) {
        return Math.min(num1, num2) + ((Math.abs(num1-num2))/2);
    }
}