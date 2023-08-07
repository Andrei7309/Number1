import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        int number = (int) (Math.random() * 100);
        String url = "http://numbersapi.com/" + number + "/trivia";
        TextService textService = new TextService();
        String response = textService.sendGetRequest(url);
        TextUtils textUtils = new TextUtils();
        Map<Character, Integer> charCountMap = textUtils.countChars(response);
        System.out.println(response);
        System.out.println(charCountMap);
    }
}