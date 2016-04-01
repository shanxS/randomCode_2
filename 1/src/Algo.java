/**
 * @author shashaku on 29/03/16.
 */
public class Algo {

    private Integer[] large = {2, 8, null, null, null, 13, null, 15, 20};//{1, null, 7,8,9,10,null};;
    private Integer[] small = {5, 7, 9, 25};//{11,12};


    public void run() {
        segrregateLarge();
        merge();

        for (Integer element : large) {
            System.out.print(element + " ");
        }
    }

    private void merge() {
        Integer largeMarker = large.length - small.length - 1;
        Integer smallMarker = small.length - 1;
        Integer writer = large.length - 1;

        while (large[writer] == null) {
            if (large[largeMarker] > small[smallMarker]) {
                large[writer] = large[largeMarker];
                large[largeMarker] = null;
                --largeMarker;
            } else if (large[largeMarker] < small[smallMarker]) {
                large[writer] = small[smallMarker];
                --smallMarker;
            } else {
                large[writer] = small[smallMarker];
                --smallMarker;
            }

            --writer;
        }
    }

    private void segrregateLarge() {
        for (Integer marker=0, explorer=0; marker<large.length && explorer<large.length; ++marker) {
            if (large[marker] == null) {
                explorer = marker+1;
                while (explorer < large.length) {

                    if (large[explorer] != null) {
                        large[marker] = large[explorer];
                        large[explorer] = null;
                        break;
                    }

                    ++explorer;
                }
            }
        }
    }


}
