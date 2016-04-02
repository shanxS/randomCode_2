/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] array1 = {1, 12, 15, 26, 38};//{1, 2, 3, 6};
    private Integer[] array2 = {2, 13, 17, 30, 45};//{4, 6, 8, 10};

    public void run() {
        Integer start1 = 0, start2 = 0;
        Integer end1 = array1.length - 1;
        Integer end2 = array2.length - 1;

        Integer median = null;

        while ((end2-start2 > 1) || (end1-start1 > 1)) {
            Integer m1 = findMedian(array1, start1, end1);
            Integer m2 = findMedian(array2, start2, end2);

            if (m1 == m2) {
                median = m1;
                break;
            } else if (m1 > m2) {

                if ((end1-start1 > 1)) {
                    end1 = mean (start1, end1);
                }

                if ((end2-start2 > 1)) {
                    start2 = mean (start2, end2);
                }

            } else if (m1 < m2) {
                if ((end1-start1 > 1)) {
                    start1 = mean (start1, end1);
                }

                if ((end2-start2 > 1)) {
                    end2 = mean (start2, end2);
                }

            }
        }

        if (median == null) {
            median = mean (Math.min(array1[end1], array2[end2]),
                        Math.max(array1[start1], array2[start2]));
        }

        System.out.print(median);
    }

    private Integer findMedian(Integer[] array, Integer start, Integer end) {
        if ((end-start+1)%2 == 0) {
            Integer index = mean (start, end);
            return mean(array[index], array[index+1]);
        } else {
            return array[mean(start, end)];
        }
    }

    private Integer mean(int num1, int num2) {
        return Math.min(num1, num2) + ((Math.abs(num1-num2))/2);
    }

}