package com.miniShop.controller;

import com.miniShop.exceptions.*;
import com.miniShop.model.Ticket;

import java.io.IOException;

public interface IStore {

    // button - "show all products in catalog "
    String printAllProducts();

    // button - "OK " in login Window
    boolean checkLoginAndPassword(String login, String password) throws NoSuchUserException, IncorrectPasswordException;

    //button - "Apply " in Registration Window
    boolean registerUser(String email, String password, String address, String creditCard) throws IllegalEmailFormatException, UserWithSuchEmailRegisteredException, IllegalPasswordFormatException, IllegalCreditCardFormatException;

    String printTicketById(int id) throws NoSuchTicketException;

    String printProductById(int id) throws NoSuchProductException;

    // send Ticket com.bestBuy.to DB
    String buy() throws TicketIsEmptyException, IOException;

    boolean loadDatabase();

    boolean saveDatabase();

    // //   create new Ticket with product ID
//    Ticket addProductByIdToTicket(int productId) throws NoSuchProductException;

//    boolean removeProductByIdFromTicket(int productId) throws NoSuchProductException;
}
