package services;

import java.util.List;
import java.util.Map;


public class Logger {
    public static void print(String response, Map<Character, Integer> charCountMap, List<Character> allSymbol, float totalFrequency, float averageFrequency) {
        System.out.println("response: " + response);

        charCountMap.forEach((key, value) -> System.out.println(key + " = " + value + " " + ending(value)));

        System.out.println("Среднее значение частоты: " + (int) totalFrequency + " / " + charCountMap.size()
                + " = " + averageFrequency);

        System.out.println("Символ наиболее близкого значения частоты к среднему значанию: ");
        allSymbol.forEach(cl ->
                System.out.println(cl.toString() + " (" + (int) cl + ")"));
    }

    private static String ending(int value) {
        String answer;
        if (((value % 10 == 2) && (value != 12)) || ((value % 10 == 3) && (value != 13)) || ((value % 10 == 4) && (value != 14))) {
            answer = "раза";
        } else {
            answer = "раз";
        }
        return answer;
    }

}