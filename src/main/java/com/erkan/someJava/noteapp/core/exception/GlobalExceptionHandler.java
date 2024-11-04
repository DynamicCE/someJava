package com.erkan.someJava.noteapp.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoteNotFoundException.class)
    public ResponseEntity<String> handleNoteNotFound(NoteNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Note not found");
    }

    @ExceptionHandler(InvalidNoteException.class)
    public ResponseEntity<String> handleInvalidNote(InvalidNoteException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid note data");
    }

    @ExceptionHandler(UnexpectedException.class)
    public ResponseEntity<String> handleUnexpectedException(UnexpectedException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
    }
}
