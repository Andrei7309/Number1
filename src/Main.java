import services.TextProvider;
import services.exception.ConnectionException;
import services.impl.TextProviderImpl;
import services.impl.TextServiceImpl;
import services.TextService;
import services.properties.ContentProperties;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws ConnectionException {
        TextService textService = new TextServiceImpl();  //todo поместить текст провайдер
        String url = "http://numbersapi.com/%s/trivia";
        String response = "";
        TextProvider textProvider = new TextProviderImpl(new ContentProperties(url));
        try {
            response = textProvider.getContent();
        } catch (IOException e) {
            String message = e.getMessage();//todo кастомную ошибку (Изучить ирархию ошибок)
            System.out.println(message);
        } catch (ConnectionException e) {
            throw new ConnectionException(e.getMessage());
        }

        textService.countAndFrequencySymbol(response);
    }
}