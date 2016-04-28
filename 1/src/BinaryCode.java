import java.util.Arrays;
import java.util.List;

public class BinaryCode {

    private Integer ar0[] = {1, 5, 10, 20, 40, 80};
    private Integer ar1[] = {6, 7, 20, 80, 100};
    private Integer ar2[] = {3, 4, 15, 20, 30, 70, 80, 120};

    public void run() {
        List<Integer> indices = Arrays.asList(new Integer[]{0,0,0});

        while (true) {
            Integer v0 = ar0[indices.get(0)];
            Integer v1 = ar1[indices.get(1)];
            Integer v2 = ar2[indices.get(2)];

            if (v0 == v1 && v1 == v2) {
                System.out.print("found common " + v0);
                break;
            } else if (v0 < v1 && v0 < v2) {

                if (indices.get(0) >= ar0.length) {
                    System.out.print("ar0 exceeded");
                    break;
                } else {
                    indices.set(0, indices.get(0) + 1);
                }

            } else if (v1 < v2 && v1 < v0) {

                if (indices.get(1) >= ar1.length) {
                    System.out.print("ar1 exceeded");
                    break;
                } else {
                    indices.set(1, indices.get(1) + 1);
                }

            } else if (v2 < v0 && v2 < v1) {

                if (indices.get(2) >= ar2.length) {
                    System.out.print("ar2 exceeded");
                    break;
                } else {
                    indices.set(2, indices.get(2) + 1);
                }

            }
        }


    }
}