package com.ekballo.celula.exceptions;

public class DuplicatedResourceException extends RuntimeException {

    public DuplicatedResourceException() {}

    public DuplicatedResourceException(String message) {
        super(message);
    }
}