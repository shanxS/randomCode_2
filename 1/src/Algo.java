public class Algo {

//    private Integer[][] A = {
//            {1,2,3},
//            {4,5,6},
//            {7,8,9},
//            {10,11,12}
//    };

    private Integer[][] A = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};

    public void run() {
        Integer initRowCount = A.length;
        Integer initColCount = A[0].length;

        Integer[][] res = new Integer[initColCount][initRowCount];

        for (Integer inputRow = 0, outputCol = initRowCount-1; inputRow < initRowCount; ++inputRow, --outputCol) {
            for (Integer inputCol = 0, outputRow = 0; inputCol < initColCount; ++inputCol, ++outputRow) {
                res[outputRow][outputCol] = A[inputRow][inputCol];
            }
        }

        for (Integer[] arr : res) {
            for (Integer ele : arr) {
                System.out.print(ele + " ");
            }

            System.out.println();
        }
    }

}