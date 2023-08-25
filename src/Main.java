import services.TextProvider;
import services.impl.TextProviderImpl;
import services.impl.TextServiceImpl;
import services.TextService;
import services.properties.ContentProperties;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        TextService textService = new TextServiceImpl();  //todo поместить текст провайдер

        String response = "";
        TextProvider textProvider = new TextProviderImpl(new ContentProperties());
        try {
            response = textProvider.getContent();
        } catch (IOException e) {
            String message = e.getMessage();//todo кастомную ошибку (Изучить ирархию ошибок)
            System.out.println(message);
        }

        textService.countAndFrequencySymbol(response);
    }
}