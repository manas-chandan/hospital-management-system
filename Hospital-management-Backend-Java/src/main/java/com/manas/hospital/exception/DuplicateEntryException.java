package com.manas.hospital.exception;

import java.util.Map;

public class DuplicateEntryException extends RuntimeException {

    private final Map<String, String> duplicateErrors;

    public DuplicateEntryException(Map<String, String> duplicateErrors) {
        super("Duplicate entry verification failed");
        this.duplicateErrors = duplicateErrors;
    }

    public Map<String, String> getDuplicateErrors() {
        return duplicateErrors;
    }
}
