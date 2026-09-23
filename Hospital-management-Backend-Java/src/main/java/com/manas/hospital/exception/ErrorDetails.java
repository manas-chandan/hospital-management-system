package com.manas.hospital.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ErrorDetails {

    private LocalDateTime timestamp;
    private String error;
    private String errorDescription;

    private Map<String, String> errors;

    public ErrorDetails(LocalDateTime timestamp, String error, String errorDescription) {
        this.timestamp = timestamp;
        this.error = error;
        this.errorDescription = errorDescription;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getError() {
        return error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    
    
}
