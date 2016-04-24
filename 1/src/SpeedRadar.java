public class SpeedRadar {

    private Integer min, max;
    private Integer speedSum;

    public double averageSpeed (int minLimit, int maxLimit, int[] readings) {

        min = minLimit;
        max = maxLimit;
        speedSum = 0;


        Integer voilationCount = countVoilation(readings);
        Integer tenPercent = (int) ((0.1) * readings.length);
        if (tenPercent < voilationCount) {
            return 0.0;
        } else {
            return new Double(speedSum/(readings.length - voilationCount));
        }
    }

    private Integer countVoilation(int[] readings) {
        Integer voilationCount = 0;

        for (Integer ele : readings) {
            if (ele < min || ele > max) {
                ++voilationCount;
            }

            speedSum += ele;
        }

        return voilationCount;
    }

}