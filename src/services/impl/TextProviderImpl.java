package services.impl;

import services.TextProvider;
import services.properties.ContentProperties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TextProviderImpl implements TextProvider {

    private final ContentProperties properties;

    @Override
    public String getContent()  throws IOException { // todo переписать на трайк кетч ресурс
        String url = properties.getUrl();
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

    public TextProviderImpl(ContentProperties properties) {
        this.properties = properties;
    }


}
