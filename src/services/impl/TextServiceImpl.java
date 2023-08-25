package services.impl;

import services.Logger;
import services.TextService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static services.TextUtils.countChars;


public class TextServiceImpl implements TextService {

    @Override
    public void countAndFrequencySymbol(String response) {

        float totalFrequency = countChars(response).values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();

        float averageFrequency = totalFrequency / countChars(response).size();

        Logger.print(response, countChars(response), closestSymbol(countChars(response), averageFrequency), totalFrequency, averageFrequency);
    }

    static List<Character> closestSymbol(Map<Character, Integer> charCountMap, float averageFrequency) {
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

//    static Comparator<Integer> comparator = ((o1, o2) -> {
//        if (o1.equals(o2)) {
//            return 0;
//        } else {
//            return o1 > o2 ? 1 : -1;
//        }
//    });
}
