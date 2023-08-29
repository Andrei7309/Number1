package services.impl;

import services.Logger;
import services.TextService;
import services.TextUtils;

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

        Logger.print(response, countChars(response), TextUtils.closestSymbol(countChars(response), averageFrequency), totalFrequency, averageFrequency);
    }
}
