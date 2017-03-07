package com.miniShop.dao;

import com.miniShop.exceptions.NoSuchProductException;
import com.miniShop.exceptions.NoSuchTicketException;
import com.miniShop.model.Product;
import com.miniShop.model.Ticket;
import com.miniShop.model.User;

public interface IDataBase {

  //  Map<Integer, Product> getAllProducts();

 //   Map<Integer, Ticket> getAllTickets();

    boolean containsUser(String login);

    User getUserByLogin(String login);

    String getUserPassword(String login);

    String allProductsToString();

    Product getProductById(int id) throws NoSuchProductException;

    Ticket getTicketById(int id) throws NoSuchTicketException;

    Ticket addTicket(Ticket ticket);

    Product addProduct(Product product);

    User addUser(User user);

    int getMaxTicketID();

    int getMaxProductID();

    boolean loadDatabase();
    boolean saveDatabase();
}
