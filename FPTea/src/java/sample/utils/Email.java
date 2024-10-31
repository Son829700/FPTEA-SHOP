/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.utils;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author User
 */
public class Email {
    private static final String FROM = "fpteashop@gmail.com";
    private static final String PASSWORD = "wpme ezyd jekm fack";

   public static void sendMail(String to, String title, String content) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); 
        props.put("mail.smtp.port", "587"); 
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM, PASSWORD);
            }
        };

        Session session = Session.getInstance(props, auth);
        MimeMessage msg = new MimeMessage(session);

        try {
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.setFrom(FROM);
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            msg.setSubject(title);
            msg.setSentDate(new Date());
            msg.setContent(content, "text/HTML; charset=UTF-8");
            Transport.send(msg);
            System.out.println("Email sent successfully");
        } catch (MessagingException e) {
            System.out.println("Error when sent mail!");
        }
    }
}
