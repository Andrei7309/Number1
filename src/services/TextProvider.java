package services;

import services.exception.ConnectionException;

import java.io.IOException;

public interface TextProvider {
    String getContent();
}
