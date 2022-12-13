package ru.springmanager.model;

public class NoSuchBookException extends Throwable {
    public NoSuchBookException(String error_book_id) {
        super(error_book_id);
    }
}
