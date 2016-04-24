import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolFrequency {

    private List<HashMap<Character, Double>> ft;
    private HashMap<Character, Double> textFreq;
    private Double charCount;

    double language(String[] frequencies, String[] text) {

        analyseText(text);
        init(frequencies);


        System.out.println("ft " + ft);
        System.out.println("textFreq " + textFreq);

        return minDeviation();

    }

    private double minDeviation() {

        Double[] deviations = new Double[ft.size()];

        for (Map.Entry<Character, Double> entry : textFreq.entrySet()) {

            Integer ftCounter = 0;
            for (Map<Character, Double> table : ft) {
                Double expected = table.get(entry.getKey());
                if (expected == null) {
                    expected = 0.;
                }

                Double found  = entry.getValue();
                BigDecimal diff = BigDecimal.valueOf(expected).subtract(BigDecimal.valueOf(found));
                System.out.println("ex " + expected + " found " + found + " " + diff.pow(2, ).doubleValue());

                deviations[ftCounter] = (deviations[ftCounter] == null) ?
                        (diff.pow(2).doubleValue()) : (deviations[ftCounter] + diff.pow(2).doubleValue());

                ++ftCounter;
            }

        }

        Integer ftCounter = 0;
        for (Map<Character, Double> table : ft) {

            for (Character c : table.keySet()) {
                if (!textFreq.containsKey(c)) {
                    System.out.println(" expected but not fount " + c);
                    //deviations[ftCounter] = (deviations[ftCounter] == null) ? 1. : (deviations[ftCounter] + 1.);
                }
            }

            ++ftCounter;
        }



        Double minDeviation = Double.MAX_VALUE;
        for (Double dev : deviations) {
            minDeviation = Math.min(minDeviation, dev);
        }

        return minDeviation/100.;

    }

    private void analyseText(String[] text) {
        Map<Character, Integer> textCount = new HashMap<>();
        charCount = 0.;
        for (String line : text) {
            for (Integer i=0; i<line.length(); ++i) {
                Character c = line.charAt(i);
                if (c == ' ') {
                    continue;
                }

                Integer count = textCount.get(c);
                if (count == null) {
                    count = 0;
                }
                ++count;
                textCount.put(c, count);

                ++charCount;
            }
        }

        System.out.println("charcoutn " + charCount + " textCount " + textCount);

        textFreq = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : textCount.entrySet()) {
            textFreq.put(entry.getKey(), ((entry.getValue() / charCount)));
        }
    }

    private void init(String[] frequencies) {

        ft = new ArrayList<>();
        for (String freq : frequencies) {

            HashMap<Character, Double> map = new HashMap<>();
            Integer counter = 0;
            while (counter < freq.length()) {
                Integer num = (10 * (Character.getNumericValue(freq.charAt(counter+1))))
                        + Character.getNumericValue(freq.charAt(counter+2));

                Double expectedFreq = (num/100.) * charCount;

                map.put(freq.charAt(counter), expectedFreq);
                counter += 3;
            }
            ft.add(map);

        }

    }

}