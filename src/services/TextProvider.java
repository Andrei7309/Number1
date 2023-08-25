package services;

import java.io.IOException;

public interface TextProvider {
    String getContent() throws IOException;
}
