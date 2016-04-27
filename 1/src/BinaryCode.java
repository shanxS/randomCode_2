public class BinaryCode {

    private Integer[] A = {2, 3, 4, 5, 6};
    public void run() {

        Integer[] res = new Integer[A.length];
        Integer counter = 1;
        Integer prodSoFar = 1;
        while (counter < A.length) {
            res[counter] = A[counter-1] * prodSoFar;

            prodSoFar = res[counter];
            ++counter;
        }

        counter = A.length-2;
        prodSoFar = 1;
        while (counter >= 0) {
            res[counter] = A[counter+1] * prodSoFar;

            prodSoFar = res[counter];
            --counter;
        }

        for (Integer ele : res) {
            System.out.print(ele + " ");
        }

    }

}