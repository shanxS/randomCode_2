import java.util.*;

public class Algo {


//    private Node[] A = {new Node(5, 24),
//            new Node(39, 60),
//            new Node(15, 28),
//            new Node(27, 40),
//            new Node(50, 90)
//    };

    private Node[] A  = {new Node(5, 24),
            new Node(15, 25),
            new Node(27, 40),
            new Node(50, 60)};

    public void run() {

        sort(0, A.length-1);

        for (Node ele : A) {
            System.out.println(ele);
        }

        List<Node> list = new ArrayList<>();
        for (Integer i=0; i<A.length; ++i) {
            if (list.size() == 0){
                list.add(A[i]);
            } else if (list.get(list.size()-1).second < A[i].first) {
                list.add(A[i]);
            } else {
                replace(list, A[i]);
            }
        }

        System.out.print(list.size());
    }

    private void replace (List<Node>list, Node node) {

        for (Integer i=list.size()-1; i>=0; --i) {
            if (list.get(i).second < node.first) {
                if (list.get(i).second >= node.second) {
                    list.set(i + 1, node);
                }

                return;
            }
        }

        if (list.get(0).second >= node.second) {
            list.set(0, node);
        }

    }

    private void sort(Integer start, Integer end) {
        if (start >= end) {
            return;
        }

        Integer pivot = quick(start, end);
        sort(start, pivot-1);
        sort(pivot+1, end);
    }

    private Integer quick(Integer start, Integer end) {
        Integer marker = start-1;
        Integer pivotValue = A[end].first;

        for (Integer i=start; i<end; ++i) {
            if (A[i].first < pivotValue) {
                ++marker;
                swap(i, marker);
            }
        }

        swap(marker+1, end);
        return marker+1;
    }

    private void swap(Integer from, Integer to) {
        Node tmp = A[from];
        A[from] = A[to];
        A[to] = tmp;
    }
}

class Node {

    public Integer first, second;

    public Node(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "Node{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}