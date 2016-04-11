public class Algo {

    private Integer[] A = {34, 23, 52, 12, 3};

    public void run() {
        Integer min = A[0];
        Integer max = A[0];
        Integer sum = 0;

        for (Integer ele : A) {
            sum += ele;

            min = Math.min(min, ele);
            max = Math.max(max, ele);
        }

        Integer ap = (A.length*(min + max))/2;
        if (sum == ap) {
            System.out.print("consecutive");
        } else {
            System.out.print("NOT consecutive");
        }



    }

}