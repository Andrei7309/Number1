package services;

import services.impl.TextServiceImpl;

import java.io.IOException;
import java.util.Map;

public class TextService implements TextServiceImpl {

    @Override
    public void start() {
        int number = (int) (Math.random() * 100);
        String url = "http://numbersapi.com/" + number + "/trivia";
        String response;
        TextProvider textProvider = new TextProvider();
        try {
            response = textProvider.textProvider(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        TextUtils textUtils = new TextUtils();
        Map<Character, Integer> charCountMap = textUtils.countChars(response);
        Logger logger1 = new Logger(response, charCountMap);
        logger1.print();
    }
}
