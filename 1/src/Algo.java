/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] A = {12, 34, 45, 9, 8, 90, 3};

    public void run() {
        Integer even = -1;
        Integer odd = 0;
        while (odd < A.length) {
            if (A[odd]%2 == 0) {
                ++even;
                swap (even, odd);
            }

            ++odd;
        }

        for (Integer ele : A) {
            System.out.print(ele + " ");
        }
    }

    private void swap(Integer from, Integer to) {
        Integer temp = A[from];
        A[from] = A[to];
        A[to] = temp;
    }
}
