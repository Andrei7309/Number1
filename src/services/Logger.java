package services;

import java.util.Map;

public class Logger {
    public void print(String response, Map<Character, Integer> charCountMap) {
        System.out.println("response: " + response);
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
