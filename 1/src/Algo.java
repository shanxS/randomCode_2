public class Algo {

    private Integer[] stack = new Integer[5];
    private Integer top1=-1, top2=stack.length;

    private Integer[] A = {1,2,3,4,5,6};

    public void run() {

        Boolean flag = true;
        for (Integer ele : A) {
            if (flag) {
                System.out.print(ele + " " + push1(ele));
            } else {
                System.out.print(ele + " " + push2(ele));
            }

            flag = !flag;
        }

        System.out.println();

        Integer data;

        while ((data = pop1()) != null) {
            System.out.println(data);
        }

        System.out.println();

        while ((data = pop2()) != null) {
            System.out.println(data);
        }
    }

    public Boolean push1 (Integer x) {
        if (top1 + 1 < top2) {
            ++top1;
            stack[top1] = x;

            return true;
        }

        return false;
    }

    public Integer pop1() {
        if (top1 >= 0) {
            --top1;
            return stack[top1+1];
        }

        return null;
    }

    public boolean push2 (Integer x) {
        if (top2-1 > top1) {
            --top2;
            stack[top2] = x;

            return true;
        }

        return false;
    }

    public Integer pop2() {
        if (top2 < stack.length) {
            ++top2;
            return stack[top2-1];
        }

        return null;
    }

}