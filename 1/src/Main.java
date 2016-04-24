/**
 * @author shashaku on 29/03/16.
 */
public class Main {

    public static void main(String[] args) {
        SpeedRadar speedRadar = new SpeedRadar();
        System.out.print(speedRadar.averageSpeed(1, 50, new int[]{42, 46, 48, 50, 52}));
    }
}
