public class BinaryCode {

    private Integer[] A = {3,1,2,2,2,1,4,3,3};
    private Integer k = 4;
    private Holder[] holder = new Holder[k-1];

    public void run() {

        for (Integer i=0; i<A.length; ++i) {
            Holder thisHolder = findHolderFor(A[i]);
            if (thisHolder == null) {
                knockOffMinHolder();
                insertHolder(A[i]);
            } else {
                thisHolder.count++;
            }
        }

        for (Integer i=0; i<holder.length; ++i) {
            if (holder[i] != null) {
                Integer value = holder[i].value;

                Integer count = 0;
                for (Integer j=0; j<A.length; ++j) {
                    if (A[j] == value) {
                        ++count;
                    }
                }
                if (count > (A.length/k)) {
                    System.out.print(value + " ");
                }
            }
        }

    }

    private void insertHolder(Integer value) {

        for (Integer i=0; i<holder.length; ++i) {
            if (holder[i] == null) {
                holder[i] = new Holder(value);
                return;
            }
        }

    }

    private void knockOffMinHolder() {
        Holder minHolder = null;
        Integer index = null;
        for (Integer i=0; i<holder.length; ++i) {
            if (holder[i] != null) {
                if (minHolder == null) {
                    minHolder = holder[i];
                    index = i;
                } else {
                    minHolder = (minHolder.count < holder[i].count) ? minHolder : holder[i];
                    index = i;
                }
            }
        }

        if (index != null) {
            if (minHolder.count == 1) {
                holder[index] = null;
            } else {
                --minHolder.count;
            }
        }

    }

    private Holder findHolderFor(Integer value) {
        for (Integer i=0; i<holder.length; ++i) {
            if (holder[i] != null && holder[i].value == value) {
                return holder[i];
            }
        }

        return null;
    }
}

class Holder {
    public Integer value;
    public Integer count;

    public Holder(Integer value) {
        this.value = value;
        this.count = 1;
    }
}