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

        while (end2-start2 > 1) {
            Integer m1 = median(array1, start1, end1);
            Integer m2 = median(array2, start2, end2);


            System.out.println("s1 " + start1 + "  e1 " + end1 + "  s2 " + start2 + "  e2 " + end2);
            System.out.println(m1 + " " + m2);

            if (m1 > m2) {

                end1 = mean(start1, end1);
                start2 = mean(start2, end2);

            } else if (m2 > m1) {

                start1 = mean(start1, end1);
                end2 = mean(start2, end2);

            } else if (m1 == m2) {

                median = m1;
                break;

            }
        }

        if (median == null) {
            System.out.println("s1 " + start1 + "  e1 " + end1 + "  s2 " + start2 + "  e2 " + end2);
            median = mean(Math.max(array1[start1], array2[start2]),
                          Math.min(array1[end1], array2[end2]));
        }

        System.out.print(median);
    }


    private Integer median (Integer[] A, Integer start, Integer end) {

        if ((end-start+1)%2 == 0) {
            Integer firstIndex = start + ((end-start)/2);
            Integer secondIndex = firstIndex + 1;
            return mean (A[firstIndex], A[secondIndex]);
        } else {
            Integer index = start + ((end-start)/2);
            return A[index];
        }

    }

    private Integer mean(Integer num1, Integer num2) {
        return (num1>num2) ? (num2 + ((num1-num2)/2)) : (num1 + ((num2-num1)/2));
    }

}