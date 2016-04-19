public class Algo {

    private Integer[] A = {20, 4, 1, 2, 3, 4, 2, 10};
    private enum Type {INC, DEC};

    public void run() {
        Integer maxDistance = Integer.MIN_VALUE;
        Integer start = null, end = null;
        Integer counter = 0;
        while (counter < A.length) {

            Integer thisStart = counter;
            Integer thisEnd = thisStart;

            Type thisType = findType(counter);
            if (thisType == Type.DEC) {
                thisEnd = findIncIndex(counter);
            } else {
                Integer endIncIndex = findDecIndex(counter);
                thisEnd = findIncIndex(endIncIndex);
            }

            if (maxDistance < (thisEnd-thisStart + 1)) {
                maxDistance = (thisEnd-thisStart + 1);
                start = thisStart;
                end = thisEnd;
            }

            counter = thisEnd;
            if (counter+1 == A.length) {
                break;
            }
        }

        System.out.print(maxDistance + " " + start + " " + end);
    }

    private Integer findDecIndex(Integer counter) {
        while (counter+1 < A.length && A[counter] < A[counter+1]) {
            ++counter;
        }

        return counter;
    }

    private Integer findIncIndex(Integer counter) {
        while (counter+1 < A.length && A[counter] > A[counter+1]) {
            ++counter;
        }

        return counter;
    }

    private Type findType(Integer counter) {
        if (counter+1 < A.length && A[counter] < A[counter+1]) {
            return Type.INC;
        }

        return Type.DEC;
    }


}