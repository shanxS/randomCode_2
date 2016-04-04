/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] A = {5,4,6,6,2};//{2, 4, 1, 3, 5};

    public void run() {
        Integer odd = 1;
        Integer even = 0;

        while (even < A.length) {
            if (A[even] % 2 != 0) {
                odd = nextOddPoistion(odd);

                if (odd >= A.length) {
                    System.out.print("no can do");
                    break;
                }

                swap(odd, even);
            }

            even += 2;
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

    private Integer nextOddPoistion(Integer odd) {
        while (odd < A.length) {
            if (A[odd] % 2 == 0) {
                break;
            }

            odd += 2;
        }

        return odd;
    }
}