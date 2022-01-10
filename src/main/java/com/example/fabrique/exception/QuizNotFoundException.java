package com.example.fabrique.exception;

public class QuizNotFoundException extends Exception {
    public QuizNotFoundException() {
    }

    public QuizNotFoundException(String message) {
        super(message);
    }
}
