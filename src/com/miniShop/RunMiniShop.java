package com.miniShop;

import com.miniShop.server.Server;
import com.miniShop.controller.MiniShop;
import com.miniShop.dao.MapDataBase;

import java.io.IOException;

public class RunMiniShop {

    public static void main(String[] args) throws IOException {

        MiniShop service = new MiniShop(new MapDataBase());
        service.loadDatabase();

        Server server = new Server(service);

//        LoginWindow log = new LoginWindow(service);

        //этот метод надо вызвать при закрытии формы
//        service.saveDatabase();
    }
}
