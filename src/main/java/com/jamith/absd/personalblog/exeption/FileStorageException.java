package com.jamith.absd.personalblog.exeption;

public class FileStorageException extends RuntimeException {
    private static final long serialVersionUID = 5205914057309685307L;

    public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
