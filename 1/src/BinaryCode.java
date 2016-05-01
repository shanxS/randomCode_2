import java.util.HashMap;
import java.util.Map;

public class BinaryCode {

    private final String A = "A";
    private final String B = "B";
    private Map<String, Integer> indices;
    private Map<String, Integer[]> arrays;
    private Integer sumA = 0;
    private Integer sumB = 0;
    private Integer maxSoFar = 0;

    public void run() {
        indices = new HashMap<>();
        indices.put(A, 0);
        indices.put(B, 0);

        arrays = new HashMap<>();
        arrays.put(A, new Integer[]{2, 3, 7, 10, 12});
        arrays.put(B, new Integer[]{1, 5, 7, 8});

        while (findCommonSum()) {
            maxSoFar += Math.max(sumA, sumB);
            maxSoFar += arrays.get(A)[indices.get(A)];
            sumA = 0;

            indices.put(A, indices.get(A)+1);
            indices.put(B, indices.get(B)+1);
            sumB = 0;
        }

        if (indices.get(A) < arrays.get(A).length) {
            while (indices.get(A) < arrays.get(A).length) {
                sumA += arrays.get(A)[indices.get(A)];
                indices.put(A, indices.get(A)+1);
            }
        }

        if (indices.get(B) < arrays.get(B).length) {
            while (indices.get(B) < arrays.get(B).length) {
                sumB += arrays.get(B)[indices.get(B)];
                indices.put(B, indices.get(B)+1);
            }
        }

        maxSoFar += Math.max(sumA, sumB);

        System.out.print(maxSoFar);


    }

    private boolean findCommonSum() {

        while (indices.get(A) < arrays.get(A).length
                && indices.get(B) < arrays.get(B).length
                && arrays.get(B)[indices.get(B)] != arrays.get(A)[indices.get(A)]) {

            while (indices.get(A) < arrays.get(A).length
                    && indices.get(B) < arrays.get(B).length
                    && arrays.get(B)[indices.get(B)] > arrays.get(A)[indices.get(A)]) {
                sumA += arrays.get(A)[indices.get(A)];
                indices.put(A, indices.get(A) + 1);
            }

            while (indices.get(A) < arrays.get(A).length
                    && indices.get(B) < arrays.get(B).length
                    && arrays.get(B)[indices.get(B)] < arrays.get(A)[indices.get(A)]) {
                sumB += arrays.get(B)[indices.get(B)];
                indices.put(B, indices.get(B) + 1);
            }
        }

        if (indices.get(A) < arrays.get(A).length
                && indices.get(B) < arrays.get(B).length
                && arrays.get(B)[indices.get(B)] == arrays.get(A)[indices.get(A)]) {
            return true;
        } else {
            return false;
        }

    }
}