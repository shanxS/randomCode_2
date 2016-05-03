public class BinaryCode {

    private Integer[] A = {10, 21, 22, 100, 101, 200, 300};

    public void run() {
        sort(0, A.length-1);

        for (Integer ele : A) {
            System.out.print(ele + " ");
        }

        Integer count = 0;
        Integer lagger = 0;
        while (lagger <= A.length-3) {

            Integer leader = lagger+1;
            while (leader <= A.length-2) {
                Integer sum = A[lagger] + A[leader];
                Integer targetIndex = find (leader+1, sum);

                if (targetIndex != null) {
                    count += targetIndex - leader;
                    System.out.println("tri " + lagger + " " + leader + " " + targetIndex);
                }

                ++leader;
            }

            ++lagger;
        }

        System.out.print("----" + count);
    }

    private Integer find(Integer start, Integer target) {
        Integer end = A.length-1;

        while (start <= end) {
            Integer mid = Math.min(start, end) + ((Math.abs(start-end))/2);
            if (A[mid].equals(target)) {

                end = mid - 1;

            } else if (A[mid] < target) {

                if ((mid+1 <= end && A[mid+1] >= target)
                        || (mid+1 > end)) {
                    return mid;
                } else {
                    start = mid+1;
                }

            } else if (A[mid] > target) {

                if (mid-1 >= start && A[mid-1] < target) {
                    return mid-1;
                } else {
                    end = mid-1;
                }

            }
        }

        return null;
    }

    private void sort(Integer start, Integer end) {
        if (start >= end) {
            return;
        }

        Integer pivot = qSort(start, end);
        sort(start, pivot-1);
        sort(pivot+1, end);
    }

    private Integer qSort(Integer start, Integer end) {
        Integer marker = start - 1;
        Integer pivotValue = A[end];

        for (Integer i=start; i<end; ++i) {
            if (A[i] <= pivotValue) {
                ++marker;
                swap(marker, i);
            }
        }

        swap(marker+1, end);
        return (marker+1);
    }

    private void swap(Integer from, Integer to) {
        Integer tmp = A[from];
        A[from] = A[to];
        A[to] = tmp;
    }
}