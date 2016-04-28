import java.util.HashMap;
import java.util.TreeSet;

public class BinaryCode {

    private Integer[][] A = {
        {1, 5, 10, 20, 40, 80},
        {6, 7, 20, 80, 100},
        {3, 4, 15, 20, 30, 70, 80, 120}
    };

    public void run() {

        TreeSet<Node> set = new TreeSet<>();
        HashMap<Integer, Integer> valueArr = new HashMap<>();

        Integer index = 0;
        for (Integer i=0; i<A.length; ++i) {
            Integer[] arr = A[i];
            set.add(new Node(arr[index], index, i));
            valueArr.put(arr[index], i);
        }

        while (set.size() > 0) {

            if (valueArr.size() == 1) {
                System.out.print("found common " + valueArr.values().toArray()[0]);

                break;
            }


            Node least = set.pollFirst();
            Integer elementIndex = least.index;
            Integer arrIndex = least.arrIndex;
            if (A[arrIndex].length <= elementIndex+1) {

                System.out.print ("out of index with arr " + arrIndex);
                break;

            } else {

                valueArr.remove(least.value);

                Node node = new Node(A[arrIndex][elementIndex+1], elementIndex+1, arrIndex);

                set.add(node);
                valueArr.put(node.value, arrIndex);

            }

        }

        System.out.print(set.toString());

    }
}

class Node implements Comparable<Node> {

    public Integer value, index, arrIndex;

    public Node(Integer value, Integer index, Integer arrIndex) {
        this.value = value;
        this.index = index;
        this.arrIndex = arrIndex;
    }

    @Override
    public int compareTo(Node o) {
        if (o.value < value) {
            return 1;
        } else if (o.value > value) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;

        Node node = (Node) o;

        if (!value.equals(node.value)) return false;
        return true;

    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + index.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "arrIndex " + arrIndex + ", index " + index + ", value " + value;
    }
}