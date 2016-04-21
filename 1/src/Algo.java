public class Algo {

    private Integer relation[][] = {
            {0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 0, 1, 0}
    };

    public void run() {


        Integer celeb = findCeleb(0, relation.length-1);

        System.out.println("ptential celeb is " + celeb);

        if (celebLitmusTest(celeb)) {
            System.out.println("celeb is " + celeb);
        } else {
            System.out.println("no celeb");
        }

    }

    private boolean celebLitmusTest(Integer celeb) {
        for (Integer i=0; i<relation.length; ++i) {
            if (i!=celeb && haveAcquaintance(celeb, i)) {
                return false;
            }
        }

        return true;
    }

    private Integer findCeleb(Integer start, int end) {
        if (start == end) {
            return start;
        } else if (end - start == 1) {
            return (haveAcquaintance(start, end)) ? (end) : (start);
        } else {

            Integer celeb1 = findCeleb(start, start + 1);
            Integer celeb2 = findCeleb(start + 2, end);

            return (haveAcquaintance(celeb1, celeb2)) ? (celeb2) : (celeb1);
        }

    }

    private Boolean haveAcquaintance(Integer A, Integer B) {
        return (relation[A][B] == 1);
    }
}