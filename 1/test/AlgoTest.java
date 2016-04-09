import org.junit.Before;
import org.junit.Test;

/**
 * @author shashaku on 09/04/16.
 */

public class AlgoTest {
    private Algo testObject;

    @Before
    public void setup(){
        testObject = new Algo();
    }

    @Test
    public void test1() {
        testObject.A =  new Integer[]{-2, -3, -4, -1, -2, -1, -5, -3};
        testObject.run();
    }


}
