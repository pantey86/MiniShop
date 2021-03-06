package com.miniShop.dao;

import com.miniShop.exceptions.NoSuchProductException;
import com.miniShop.exceptions.NoSuchTicketException;
import com.miniShop.model.Configuration;
import com.miniShop.model.Product;
import com.miniShop.model.Ticket;
import com.miniShop.model.User;
import com.miniShop.to.FileHelper;
import com.miniShop.to.Serializer;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class MapDataBase implements IDataBase {

    private static String FILE_FOR_PRODUCTS;
    private static String FILE_FOR_TICKETS;
    private static String FILE_FOR_USERS;

    private Map<Integer, Product> products;
    private Map<Integer, Ticket> tickets;
    private Map<String, User> users;

    public MapDataBase() throws IOException {
        Properties config = Configuration.getConfig();
        FILE_FOR_PRODUCTS = config.getProperty("FILE_FOR_PRODUCTS");
        FILE_FOR_TICKETS = config.getProperty("FILE_FOR_TICKETS");
        FILE_FOR_USERS = config.getProperty("FILE_FOR_USERS");
    }

    public MapDataBase(Map<Integer, Product> products, Map<Integer, Ticket> tickets, Map<String, User> users) {
        this.products = products;
        this.tickets = tickets;
        this.users = users;
    }

    @Override
    public Ticket addTicket(Ticket ticket) {
        return tickets.put(getMaxTicketID() + 1, ticket);
    }

    @Override
    public Product addProduct(Product product) {
        return products.put(getMaxProductID() + 1, product);
    }

    @Override
    public User addUser(User user) {
        return users.put(user.getEmail(), user);
    }


    @Override
    public boolean containsUser(String login) {
        return users.containsKey(login);
    }

    @Override
    public User getUserByLogin(String login) {
        return users.get(login);
    }

    @Override
    public String getUserPassword(String login) {
        return users.get(login).getPassword();
    }

    @Override
    public String allProductsToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer, Product> e : products.entrySet()) {
            stringBuilder.append("ID : ").append(e.getKey()).append(" Product : ").append(e.getValue().toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Product getProductById(int id) throws NoSuchProductException {
        Product pr = products.get(id);
        if (pr == null) {
            throw new NoSuchProductException("No such product with this id " + id);
        }
        return pr;
    }

    @Override
    public Ticket getTicketById(int id) throws NoSuchTicketException {
        Ticket ticket = tickets.get(id);
        if (ticket == null) {
            throw new NoSuchTicketException("No such ticket with this id " + id);
        }
        return ticket;
    }

    @Override
    public int getMaxTicketID() {
        int maxKey = 0;
        for (Integer me : tickets.keySet()) {
            if (me > maxKey) {
                maxKey = me;
            }
        }
        return maxKey;
    }

    @Override
    public int getMaxProductID() {
        int maxKey = 0;
        for (Integer me : products.keySet()) {

            if (me > maxKey) {
                maxKey = me;
            }
        }
        return maxKey;
    }


    @Override
    public boolean loadDatabase() {
        FileHelper fh = new FileHelper();
        Serializer<Integer, Product> serProd = new Serializer<>();
        Serializer<Integer, Ticket> serTicket = new Serializer<>();
        Serializer<String, User> serUser = new Serializer<>();
        String jsonProduct, jsonTicket, jsonUser;

        try {
            jsonProduct = fh.readFromFile(FILE_FOR_PRODUCTS);
            jsonTicket = fh.readFromFile(FILE_FOR_TICKETS);
            jsonUser = fh.readFromFile(FILE_FOR_USERS);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        products = serProd.convertJsonToProduct(jsonProduct);
        tickets = serTicket.convertJsonToTicket(jsonTicket);
        users = serUser.convertJsonToUser(jsonUser);

        return true;
    }

    @Override
    public boolean saveDatabase() {

        FileHelper fh = new FileHelper();
        Serializer<Integer, Product> serProd = new Serializer();
        Serializer<Integer, Ticket> serTicket = new Serializer<>();
        Serializer<String, User> serUser = new Serializer<>();
        try {
            fh.writeToFile(serProd.convertObjectToJson(products), FILE_FOR_PRODUCTS);
            fh.writeToFile(serTicket.convertObjectToJson(tickets), FILE_FOR_TICKETS);
            fh.writeToFile(serUser.convertObjectToJson(users), FILE_FOR_USERS);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
