import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int number = (int) (Math.random() * 100);
        String url = "http://numbersapi.com/" + number + "/trivia";
        String response = null;
        try {
            response = sendGetRequest(url);
            System.out.println("Response: " + response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int[] countSymbol = countSymbol(response);
        char[] ch = response.toCharArray();
        Set<Character> chars = new HashSet<>();
        for (char c : ch) {
            chars.add(c);
        }
        for (char cha: chars) {
            System.out.println(cha + " " + countSymbol[cha] + " раз");
        }
    }


    private static String sendGetRequest(String url) throws IOException {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    private static int[] countSymbol(String str) {
        int[] charCount = new int[256];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            charCount[ch]++;
        }

        return charCount;
    }
}