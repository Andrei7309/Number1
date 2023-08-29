import services.TextProvider;
import services.exception.ConnectionException;
import services.impl.TextProviderImpl;
import services.impl.TextServiceImpl;
import services.TextService;
import services.properties.ContentProperties;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws ConnectionException {

        String url = "http://numbersapi.com/%s/trivia";

        TextProvider textProvider = new TextProviderImpl(new ContentProperties(url));
        String response = textProvider.getContent();

        TextService textService = new TextServiceImpl();
        textService.countAndFrequencySymbol(response);
    }
}