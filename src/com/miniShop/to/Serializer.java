package com.miniShop.to;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.miniShop.model.Product;
import com.miniShop.model.Ticket;
import com.miniShop.model.User;

import java.lang.reflect.Type;
import java.util.Map;

public class Serializer<K,T> {
    // map com.miniShop.to json
    public String convertObjectToJson(Map<K, T> map) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(map);
    }

    // json com.miniShop.to object
    public Map<Integer, Product> convertJsonToProduct(String txt) {
        Type type = new TypeToken<Map<Integer, Product>>() {
        }.getType();
        return new Gson().fromJson(txt, type);
    }

    public Map<Integer, Ticket> convertJsonToTicket(String txt) {
        Type type = new TypeToken<Map<Integer, Ticket>>() {
        }.getType();
        return new Gson().fromJson(txt, type);
    }

    public Map<String,User> convertJsonToUser(String txt) {
        Type type = new TypeToken<Map<String, User>>() {
        }.getType();
        return new Gson().fromJson(txt, type);
    }

    // json com.miniShop.to object
    public Map<String, Integer> convertJsonIDToObject(String txt) {
        Type type = new TypeToken<Map<String, Integer>>() {
        }.getType();
        return new Gson().fromJson(txt, type);
    }
}