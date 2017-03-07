package com.miniShop.exceptions;

public class TicketIsEmptyException extends Exception {
    public TicketIsEmptyException(String message) {
        super(message);
    }
}
