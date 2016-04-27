public class BinaryCode {

    private Integer[] A = {12, 34, 10, 6, 40};

    public void run() {

        Integer max = Integer.MIN_VALUE;
        Integer sMax = Integer.MIN_VALUE;

        for (Integer ele : A) {

            if (ele > max) {
                sMax = max;
                max = ele;
            } else if (ele > sMax) {
                sMax = ele;
            }

        }

        System.out.print(sMax + max);

    }
}