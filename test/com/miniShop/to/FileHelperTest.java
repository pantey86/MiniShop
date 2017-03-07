package com.miniShop.to;

import org.junit.Assert;


public class FileHelperTest {

    private FileHelper fileHelper = new FileHelper();
    @org.junit.Test
    public void readFromFile() throws Exception {
        String str = fileHelper.readFromFile("test/com/bestBuy/to/test.txt");
        Assert.assertEquals(str, "Hello World! 1234466");

    }

    @org.junit.Test
    public void writeToFile() throws Exception {
        Assert.assertTrue(fileHelper.writeToFile("Hello World! 1234466","test/com/bestBuy/to/test.txt"));
    }

}