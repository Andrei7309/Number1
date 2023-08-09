package services;

import java.util.Map;

public class Logger {
    String response;
    Map<Character, Integer> charCountMap;

    public Logger(String response, Map<Character, Integer> charCountMap) {
        this.response = response;
        this.charCountMap = charCountMap;
    }

    public void print() {
        System.out.println("services.Logger{" +
                "response='" + response + "\n" +
                ", charCountMap=" + charCountMap +
                '}');
    }
}
