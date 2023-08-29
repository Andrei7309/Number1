package services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class TextUtils { //не изм сделать

    private TextUtils() {

    }
    public static Map<Character, Integer> countChars(String str) {

        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            if (charCountMap.containsKey(ch)) {
                charCountMap.put(ch, charCountMap.get(ch) + 1);
            } else {
                charCountMap.put(ch, 1);
            }
        }
        return charCountMap;
    }
    public static List<Character> closestSymbol(Map<Character, Integer> charCountMap, float averageFrequency) {
        int closestSymbol = 0;
        float closestFrequencyDifference = Integer.MAX_VALUE;

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if ((Math.abs(entry.getValue() - averageFrequency)) < closestFrequencyDifference) {
                closestSymbol = entry.getValue();
                closestFrequencyDifference = Math.abs(entry.getValue() - averageFrequency);
            }
        }

        int finalClosestSymbol = closestSymbol;
        return charCountMap.entrySet()
                .stream()
                .filter(x -> x.getValue() == finalClosestSymbol)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}