public class Algo {

    private Integer relation[][] = {
            {0, 0, 1, 0},
            {0, 0, 1, 0},
            {1, 0, 0, 0},
            {0, 0, 1, 0}
    };

    public void run() {

        Integer A = 0;
        for (Integer B=1; B<relation.length; ++B) {
            if (haveAcquaintance(A, B)) {
                A = B;
            }
        }

        System.out.println("potential celeb " + A);

        for (Integer other = 0; other<relation.length; ++other) {
            if (other != A && haveAcquaintance(A, other)) {
                System.out.println("no celeb");

                return;
            }
        }

        System.out.println("celeb is " + A);

    }

    private Boolean haveAcquaintance(Integer A, Integer B) {
        return (relation[A][B] == 1);
    }
}