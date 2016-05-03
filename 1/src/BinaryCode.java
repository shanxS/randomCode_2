import java.util.Random;

public class BinaryCode {

    private Integer[] A = {1, 2, 3, 4, 5, 6, 7, 8};

    public void run() {

        Random rand = new Random();
        for (Integer i=A.length-1; i>0; --i) {
            Integer fromIndex = rand.nextInt(i);
            swap(fromIndex, i);
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
}