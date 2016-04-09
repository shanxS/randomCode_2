/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] A = {1, 2, 8, 10, 10, 12, 19};

    public void run() {
        LimitFinder lf = new LimitFinder();
        lf.find(A, 0);
        System.out.print(lf.getCeil() + " " + lf.getFloor());
    }
}

class LimitFinder {
    private Integer[] A;
    private Integer ceil;
    private Integer floor;

    public Integer getCeil() {
        return ceil;
    }

    public Integer getFloor() {
        return floor;
    }

    public void find(Integer[] A, Integer value) {
        this.A = A;

        findFor(0, A.length-1, value);
    }

    private void findFor(Integer start, Integer end, Integer target) {
        if (start > end) {
            return;
        }

        Integer mid = Math.min(start, end) + ((Math.abs(start-end))/2);
        if (A[mid] > target) {
            ceil = A[mid];
            end = mid-1;
        } else if (A[mid] < target) {
            floor = A[mid];
            start = mid+1;

        } else {
            floor = A[mid];
            ceil = A[mid];

            return;
        }

        findFor(start, end, target);
    }


}