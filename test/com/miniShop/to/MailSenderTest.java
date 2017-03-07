package com.miniShop.to;

import com.miniShop.model.Ticket;
import com.miniShop.model.User;
import com.miniShop.to.MailSender;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;


public class MailSenderTest {
    MailSender mailSender = new MailSender();

    public MailSenderTest() throws IOException {

    }

    @Test
    public void sendMailTest(){
        User user = new User("ksyashka19@gmail.com", "123456", "4444", "Kiev");
        Ticket ticket = new Ticket(user,5);
        assertTrue(mailSender.sendMail(ticket));
    }

}
