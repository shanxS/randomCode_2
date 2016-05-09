public class BinaryCode {

    private Integer[] A = {-1, 2, -3, 4, 5, -7, -8};

    public void run() {

        Integer even = 0;
        Integer odd = 1;

        while (even < A.length && odd < A.length) {
            if (A[even] < 0) {

                odd = findPositive(odd);
                if (odd < A.length) {
                    swap(odd, even);
                }

                even += 2;
            } else if(A[odd] > 0) {
                even = findNegative(even);
                if (even < A.length) {
                    swap(even, odd);
                }

                odd += 2;
            } else {
                even += 2;
                odd += 2;
            }
        }


        for (Integer ele : A) {
            System.out.print(ele + " ");
        }
    }

    private void swap(Integer from, Integer to) {
        Integer tmp = A[from];
        A[from] = A[to];
        A[to] = tmp;
    }

    private Integer findNegative(Integer start) {
        while (start<A.length && A[start] > 0) {
            start += 2;
        }

        return start;
    }

    private Integer findPositive(Integer start) {

        while (start<A.length && A[start] < 0) {
            start += 2;
        }

        return start;
    }
}