package services;

import java.util.Map;

public class Logger {
    public void print(String response, Map<Character, Integer> charCountMap) {
        System.out.println("response: " + response);
        float totalFrequency = 0;
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue() + " " + ending(entry.getValue()));
            totalFrequency += entry.getValue();
        }
        float averageFrequency = totalFrequency / charCountMap.size();
        System.out.println("Среднее значение частоты " + totalFrequency +  " / " + charCountMap.size()
        + " = " + averageFrequency);
        System.out.println("Символ наиболее близкого значения частоты к среднему значанию: " +
               closestSymbol(charCountMap, averageFrequency) + " (" + (int) closestSymbol(charCountMap, averageFrequency) +  ")" );
    }

    String ending(int value) {
        String answer;
        if ((value % 10 == 2) || (value % 10 == 3) || (value % 10 == 4)) {
            answer = "раза";
        } else {
           answer = "раз";
        }
        return answer;
    }

    char closestSymbol(Map<Character, Integer> charCountMap, float averageFrequency){
        char closestSymbol = ' ';
        int closestFrequencyDifference = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if ((Math.abs(entry.getValue() - averageFrequency)) < closestFrequencyDifference){
                closestSymbol = entry.getKey();
                closestFrequencyDifference = Math.abs(entry.getKey());
            }
        }
        return closestSymbol;
    }
}