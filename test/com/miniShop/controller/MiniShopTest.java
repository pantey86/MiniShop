package com.miniShop.controller;


/**
 * Created by fmandryka on 19.02.2017.
 */
public class MiniShopTest {
   /* Product pr1 = new Product("Iron", 1, 300.00);
    Product pr2 = new Product("Cup", 2, 100);
    Product pr3 = new Product("Phone", 3, 3000);
    Product pr4 = new Product("HDD", 4, 1000);
    Product pr5 = new Product("SSD", 5, 2000);
    Map<Integer, Product> baseProd = new HashMap<>();
    List<Integer> ticket1Products = new ArrayList<>();

    Ticket t1;
    Map<Integer, Ticket> baseTick = new HashMap<>();
    MapDataBase db = new MapDataBase(baseProd,baseTick);
    BestBuy service;

    @Before
    public void setUp(){

        baseProd.put(pr1.getId(),pr1);
        baseProd.put(pr2.getId(),pr2);
        baseProd.put(pr3.getId(),pr3);
        baseProd.put(pr4.getId(),pr4);
        baseProd.put(pr5.getId(),pr5);
        ticket1Products.add(1);
        t1 = new Ticket(1, ticket1Products, "Kyiv", "4444 4444 4444 4444");
        baseTick.put(t1.getId(),t1);
        service = new BestBuy(db);
    }

    @org.junit.Test
    public void getAllProductsTest() throws Exception {
        Assert.assertEquals(baseProd, service.getAllProducts());
    }

    @org.junit.Test
    public void getProductByIdTest() throws Exception {
        Assert.assertEquals(pr3, service.getProductById(3));
    }

    @org.junit.Test
    public void buyTest() throws Exception {
        List<Integer> ticket2Products = new ArrayList<>();
        ticket2Products.add(4);
        service.buy("Kyiv","4444 4444 4444 4445",ticket2Products);

//        Ticket t = new Ticket(db.getMaxTicketID(),4,"Kyiv", "4444 4444 4444 4445");

        Assert.assertNotNull(service.showTicketById(2));
    }

    @org.junit.Test
    public void showTicketByIdTest() throws Exception {
        Assert.assertEquals(t1, service.showTicketById(1));
    }
*/
}