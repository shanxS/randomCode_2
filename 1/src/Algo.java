/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] A = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
//    private Integer[] A = {0, 1, 15, 25, 6, 7, 30, 40, 50};

    public void run() {
        Integer minErrand = null;
        Integer counter = 0;
        while (counter < A.length-1 && A[counter] < A[counter+1]) {
            ++counter;
        }
        if (counter == A.length-1) {
            System.out.print("sorted array");
        } else {
            minErrand = counter;
        }

        Integer maxErrand = null;
        counter = A.length-1;
        while (counter > 0 && A[counter] > A[counter-1]) {
            --counter;
        }
        maxErrand = counter;

        Integer maxErrandInit = maxErrand;
        Integer minErrandInit = minErrand;
        counter = minErrandInit;
        while (counter <= maxErrandInit) {
            if (A[counter] > A[maxErrand]) {
                maxErrand = counter;
            } else if (A[counter] < A[minErrand]) {
                minErrand = counter;
            }

            ++counter;
        }

        counter = 0;
        while (counter <= minErrand && A[counter] < A[minErrand]) {
            ++counter;
        }
        minErrand = counter;

        counter = A.length-1;
        while (counter >= maxErrand && A[counter] > A[maxErrand]) {
            --counter;
        }
        maxErrand = counter;

        System.out.print(minErrand + " " + maxErrand);

    }

}
