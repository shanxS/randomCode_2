/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] A = {1, 2, 8, 10, 10, 12, 19};

    public void run() {
        BinarySearch bs = new BinarySearch();
        System.out.print(bs.search(A, 6));
    }
}

class BinarySearch {
    private Integer[] A;

    public Integer search(Integer[] A, Integer target) {
        this.A = A;
        return find(0, A.length-1, target);
    }

    private Integer find(int start, int end, Integer target) {
        if (start > end) {
            return null;
        }

        Integer mid = Math.min(start, end) + ((Math.abs(start-end))/2);

        if (A[mid] == target) {
            return mid;
        } else if (A[mid] > target) {
            end = mid - 1;
            return find (start, end, target);
        } else {
            start = mid + 1;
            return find (start, end, target);
        }
    }
}