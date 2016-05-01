public class BinaryCode {

    private Integer[] A1 = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
    private Integer[] A2 = {2, 1, 8, 3};
    private Boolean[] visited = new Boolean[A1.length];

    public void run() {
        sort(0, A1.length-1);
        for (Integer ele : A2) {
            Integer index = find (ele);
            while (index != null
                    && index < A1.length
                    && A1[index] == ele) {
                System.out.print(ele + " ");
                visited[index] = true;
                ++index;
            }
        }

        for (Integer i=0; i<A1.length; ++i) {
            if (visited[i] ==null || !visited[i]) {
                System.out.print(A1[i] + " ");
            }
        }

    }

    private Integer find(Integer ele) {
        Integer start = 0;
        Integer end = A1.length-1;

        while (start <= end) {
            Integer mid = Math.min(start, end) + ((Math.abs(start-end))/2);

            if (A1[mid] == ele) {
                return mid;
            } else if (A1[mid] > ele) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }


        return null;
    }

    private void sort(Integer start, Integer end) {
        if (start >= end) {
            return;
        }

        Integer pivot = qsort(start, end);
        sort(start, pivot-1);
        sort(pivot+1, end);
    }

    private Integer qsort(Integer start, Integer end) {
        Integer marker = start-1;
        Integer pivotValue = A1[end];

        for (Integer i=start; i<end; ++i) {
            if (A1[i] < pivotValue) {
                ++marker;
                swap(marker, i);
            }
        }

        swap(marker+1, end);
        return marker+1;
    }

    private void swap(Integer from, Integer to) {
        Integer tmp = A1[from];
        A1[from] = A1[to];
        A1[to] = tmp;

    }
}