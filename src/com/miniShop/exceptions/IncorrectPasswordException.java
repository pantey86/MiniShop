package com.miniShop.exceptions;

public class IncorrectPasswordException extends Exception {
    public IncorrectPasswordException() {
    }

    public IncorrectPasswordException(String s) {
        super(s);
    }
}
