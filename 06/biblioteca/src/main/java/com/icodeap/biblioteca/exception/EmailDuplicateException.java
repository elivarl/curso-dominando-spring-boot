package com.icodeap.biblioteca.exception;

public class EmailDuplicateException extends RuntimeException{
    private String fieldName;
    private String fieldValue;

    public EmailDuplicateException(String fieldName, String fieldValue) {
        super(String.format("%s %s ya existe", fieldName, fieldValue));
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
