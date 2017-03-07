package com.miniShop.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration extends Properties {

    private static Properties config;

    private Configuration() {
    }

    public static Properties getConfig() throws IOException {
        if (Configuration.config == null) {
            config = new Properties();
            FileInputStream fi = new FileInputStream("E:/IntellijWorkspace/MiniShop/resources/config.properties");
            config.load(fi);
        }
        return config;
    }
}
