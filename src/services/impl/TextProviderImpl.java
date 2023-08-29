package services.impl;

import services.TextProvider;
import services.exception.ConnectionException;
import services.properties.ContentProperties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectStreamException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Formatter;

public class TextProviderImpl implements TextProvider {

    private final ContentProperties properties;

    @Override
    public String getContent() { // переписать на трайк кетч ресурс
        var connection = createConnection(properties.getUrl());
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            return response.toString();
        } catch (IOException e) {
            throw new ConnectionException(e.getMessage()); //кастомные ошибки изучить и сюда добавить
        }
    }

    public TextProviderImpl(ContentProperties properties) {
        this.properties = properties;
    }

    private HttpURLConnection createConnection(String url) {
        try {
            String currentUrl = String.valueOf(new Formatter().format(url, (int) (Math.random() * 100)));
            var obj = new URL(currentUrl);
            HttpURLConnection openConnection = (HttpURLConnection) obj.openConnection();
            openConnection.setRequestMethod("GET");
            return openConnection;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
