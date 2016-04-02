/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] array1 = {1, 2, 3, 6};//{1, 12, 15, 26, 38};
    private Integer[] array2 = {4, 6, 8, 10};//{2, 13, 17, 30, 45};

    public void run() {
        Integer start1 = 0;
        Integer start2 = 0;
        Integer end1 = array1.length - 1;
        Integer end2 = array2.length - 1;

        Integer median = null;

        while ((end1-start1) > 1 || (end2-start2) > 1) {
            Integer m1 = findMedian(array1, start1, end1);
            Integer m2 = findMedian(array2, start2, end2);

            if (m1 == m2) {
                median = m1;
                break;
            } else if (m1 > m2) {
                if ((end1-start1) > 1) {
                    end1 = mean(start1, end1);
                }

                if ((end2-start2) > 1) {
                    start2 = mean(start2, end2);
                }

            } else if (m1 < m2) {
                if ((end1-start1) > 1) {
                    start1 = mean(start1, end1);
                }

                if ((end2-start2) > 1) {
                    end2 = mean(start2, end2);
                }
            }
        }

        if (median == null) {
            median = mean (Math.max(array1[start1], array2[start2]),
                            Math.min(array1[end1], array2[end2]));
        }

        System.out.print(median);
    }

    private Integer findMedian(Integer[] array, Integer start, Integer end) {
        if ((end-start+1)%2 == 0) {
            Integer meanIndex = mean(start, end);
            Integer value1 = array[meanIndex];
            Integer value2 = array[meanIndex+1];
            return mean(value1, value2);
        } else {
            return array[mean(start, end)];
        }
    }

    private Integer mean(Integer num1, Integer num2) {
        return Math.min(num1, num2) + ((Math.abs(num1-num2))/2);
    }

}