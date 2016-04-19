public class Algo {

    private Integer[] A = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
    private Integer[] minJumps = new Integer[A.length];
    private final Integer INF = Integer.MAX_VALUE;

    public void run() {

        for (Integer i=A.length-1; i>=0;--i) {
            findMinJumps(i);
        }

        System.out.println(minJumps[0]);

        for (Integer ele : minJumps) {
            System.out.print(ele + " ");
        }


    }

    private void findMinJumps(Integer source) {

        if ((A.length - source) <= A[source]) {
            minJumps[source] = 1;
        } else {
            minJumps[source] = INF;
        }

        Integer minJump = minJumps[source];
        for (Integer i=1; i<=A[source] && (i+source) < A.length; ++i) {
            if (minJumps[i+source] != INF && 1 + minJumps[i+source] < minJump) {
                minJump = 1+minJumps[i+source];
            }
        }
        minJumps[source] = minJump;
    }
}