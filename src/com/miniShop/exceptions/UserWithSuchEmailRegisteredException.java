package com.miniShop.exceptions;

public class UserWithSuchEmailRegisteredException extends Exception {
    public UserWithSuchEmailRegisteredException(String s) {
        super(s);
    }
}
