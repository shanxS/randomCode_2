public class BinaryCode {

    int f(int x) { return (x*x*x + 20); }
    private Integer start, end;

    public void run() {

        if (f(0) > 0) {

            end = 0;
            start = -2;
            while (f(start) > 0) {
                end = start;
                start *= -start;
            }

        } else {

            start = 0;
            end = 2;
            while (f(end) <= 0) {

                start = end;
                end *= end;

            }

        }

        System.out.print(find(start, end));

    }

    private Integer find(Integer start, Integer end) {
        while (start <= end) {
            Integer mid = Math.min(start, end) + ((Math.abs(start-end))/2);

            if (f(mid) == 0) {
                start = mid+1;
            } else if (f(mid) > 0) {
                if ((mid-1 < start) ||
                        (f(mid-1) < 0)) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            } else {
                start = mid + 1;
            }
        }

        return null;
    }
}