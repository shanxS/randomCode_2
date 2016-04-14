public class Algo {

    private Integer[] A = {4, 3, 6, 2, 1, 1};

    public void run() {

        Integer[] store = new Integer[A.length];

        for (Integer ele : A) {
            if (store[(ele - 1)] != null) {
                System.out.print("repeated " + ele);
            } else {
                store[(ele - 1)] = ele;
            }
        }

        for (Integer i=0; i<A.length; ++i) {
            Integer ele = store[i];
            if (ele == null) {
                System.out.print("not found " + (i+1));
            }
        }
    }
}