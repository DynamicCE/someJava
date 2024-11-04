package com.erkan.someJava.noteapp.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidNoteException extends RuntimeException {
    public InvalidNoteException() {
        super();
    }
}