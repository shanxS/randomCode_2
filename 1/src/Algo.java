import java.util.*;

public class Algo {

    private Integer[] A = {10, 2, 3, 4, 5, 9, 7, 8};
    private Integer target = 23;
    private Map<Integer, Node> sumMap;

    public void run() {

        init();

        for (Integer i = A.length - 1; i >= 3; --i) {
            for (Integer j = i - 1; j >= 2; --j) {

                Integer diff = target - (A[i] + A[j]);
                Node node = sumMap.get(diff);
                if (node != null) {
                    System.out.println(A[i] + " " + A[j] + " " + node.num1 + " " + node.num2);
                }
            }
        }
    }

    private void init() {
        sumMap = new HashMap<>();

        for (Integer i=0; i<A.length; ++i) {
            for (Integer j=i+1; j<A.length; ++j) {
                Integer sum = A[i] + A[j];
                sumMap.put(sum, new Node(A[i], A[j], i, j));
            }
        }

    }
}

class Node {
    public Integer num1, num2;
    public Integer index1, index2;

    public Node(Integer num1, Integer num2, Integer index1, Integer index2) {
        this.num1 = num1;
        this.num2 = num2;
        this.index1 = index1;
        this.index2 = index2;
    }
}